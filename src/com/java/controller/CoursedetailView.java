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
 * Servlet implementation class CoursedetailView
 */
@WebServlet("/CoursedetailView")
public class CoursedetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursedetailView() {
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
		Coursedetail coursedetail;
		ArrayList<Coursedetail> cd_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select dc.c_code,c.c_name,dc.sem_id,ds.sem_name,s.year from d_course dc,course c,d_semester ds,semester s where ds.sem_id = dc.sem_id and dc.c_code = c.c_code and s.sem_id = dc.sem_id";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				coursedetail = new Coursedetail();
				coursedetail.setC_code(rs.getString("c_code"));
				coursedetail.setC_name(rs.getString("c_name"));
				coursedetail.setSemId(rs.getString("sem_id"));
				coursedetail.setSemName(rs.getString("sem_name"));
				coursedetail.setYear(rs.getString("year"));
				cd_list.add(coursedetail);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("coursedetail_view", cd_list);
			
			response.setContentType("text/plain");
			response.getWriter().println("coursedetailview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
