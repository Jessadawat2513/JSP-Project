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
 * Servlet implementation class CourseView
 */
@WebServlet("/CourseView")
public class CourseView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseView() {
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
		Course course;
		ArrayList<Course> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select c_code ,c_name ,credit,s_c_id from course";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				course = new Course();
				course.setCourseCode(rs.getString("c_code"));
				course.setCourseName(rs.getString("c_name"));
				course.setCredit(rs.getString("credit"));
				course.setStatusId(rs.getString("s_c_id"));
				list.add(course);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("courseview", list);
			
			response.setContentType("text/html");
			response.getWriter().print("courseview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
