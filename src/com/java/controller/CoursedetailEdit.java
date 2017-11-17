package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class CoursedetailEdit
 */
@WebServlet("/CoursedetailEdit")
public class CoursedetailEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursedetailEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String semesters = request.getParameter("semester");
		boolean state = false;
		
		Semester semester;
		ArrayList<Semester> sem_list = new ArrayList<>();
		
		Course course;
		ArrayList<Course> course_list = new ArrayList<>();
		ArrayList<Course> course_data = new ArrayList<>();
		
		Coursedetail coursedt = new Coursedetail();
		Coursedetail coursedetail = null;
		ArrayList<Coursedetail> cd_list = new ArrayList<>();
		
		Map<String, String> data = new LinkedHashMap<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select s.sem_id,d.sem_name,s.year from semester s,d_semester d where s.sem_id = d.sem_id order by s.sem_id,s.year asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				semester = new Semester();
				semester.setSemesterId(rs.getString("sem_id"));
				semester.setSemesterName(rs.getString("sem_name"));
				semester.setYear(rs.getString("year"));
				sem_list.add(semester);
			}
			
			String qr1 = "select substr('"+semesters+"',1,3) as semester , substr('"+semesters+"',4,4) as year from dual";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				coursedt.setSemId(rs.getString("semester"));
				coursedt.setYear(rs.getString("year"));
				
				String qr2 = "select d.c_code,c.c_name,d.sem_id,d.year from d_course d,course c where d.c_code = c.c_code and d.sem_id = '"+rs.getString("semester")+"' and d.year = '"+rs.getString("year")+"'";
				
				st = conn.createStatement();
				rs = st.executeQuery(qr2);
				
				while(rs.next()){
					coursedetail = new Coursedetail();
					coursedetail.setC_code(rs.getString("c_code"));
					coursedetail.setC_name(rs.getString("c_name"));
					cd_list.add(coursedetail);
				}
			}
			
			String qr4 = "select c_code,c_name from course";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr4);
			while(rs.next()){
				course = new Course();
				course.setCourseCode(rs.getString("c_code"));
				course.setCourseName(rs.getString("c_name"));
				state = true;
				for(Coursedetail coursedetail1 : cd_list){
					if(coursedetail1.getC_code().equals(course.getCourseCode())){
						state = false;
						break;
					}
				}
				if(state){
					course_list.add(course);
				}
			}

			HttpSession session = request.getSession();
			session.setAttribute("sem_list", sem_list);
			session.setAttribute("course_list", course_list);
			session.setAttribute("cd_list", cd_list);
			session.setAttribute("coursedt", coursedt);
			
		}catch(SQLException ex){
			
		}
	}

}
