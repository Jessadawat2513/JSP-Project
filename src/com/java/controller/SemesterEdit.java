package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class SemesterEdit
 */
@WebServlet("/SemesterEdit")
public class SemesterEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterEdit() {
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
		String semester = request.getParameter("semesters");
		String year = request.getParameter("years");
		
		Semester semesters = new Semester();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select sem_id,year,start_date,end_date,s_sem_id from semester where sem = '"+semester+"' AND year = '"+year+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				semesters.setSemesterId(rs.getString("sem_id"));
				semesters.setYear(rs.getString("year"));
				semesters.setStartdate(rs.getString("start_date"));
				semesters.setEnddate(rs.getString("end_date"));
				semesters.setStatusId(rs.getString("s_sem_id"));
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("semesteredit", semesters);
			
			response.setContentType("text/html");
			response.getWriter().print("semesteredit.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
