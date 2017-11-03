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

import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class CoursedetailAddView
 */
@WebServlet("/CoursedetailAddView")
public class CoursedetailAddView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursedetailAddView() {
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
		Semester semester;
		ArrayList<Semester> sem_list = new ArrayList<>();
		
		Course course;
		ArrayList<Course> course_list = new ArrayList<>();
		
		Year year = new Year();
		Year year1;
		ArrayList<Year> year_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select sem_id,sem_name from d_semester order by sem_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				semester = new Semester();
				semester.setSemesterId(rs.getString("sem_id"));
				semester.setSemesterName(rs.getString("sem_name"));
				sem_list.add(semester);
			}
			
			String qr1 = "select to_char(sysdate,'YYYY') as year from dual";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				year.setYear(rs.getString("year"));
				for(int i = Integer.parseInt(year.getYear())-10;i<=Integer.parseInt(year.getYear())+20;i++){
					year1 = new Year();
					year1.setYear(Integer.toString(i));
					year_list.add(year1);
				}
			}
			
			String qr2 = "select c_code,c_name from course";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				course = new Course();
				course.setCourseCode(rs.getString("c_code"));
				course.setCourseName(rs.getString("c_name"));
				course_list.add(course);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("sem_list",sem_list);
			session.setAttribute("year_list", year_list);
			session.setAttribute("course_list", course_list);
			
		}catch(SQLException ex){
			
		}
	}

}
