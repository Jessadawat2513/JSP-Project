package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class SemesterUpdate
 */
@WebServlet("/SemesterUpdate")
public class SemesterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterUpdate() {
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
		String semesters = request.getParameter("semesters");
		String years = request.getParameter("years");
		
		String semester = request.getParameter("semester");
		String year = request.getParameter("year");
		String stdate = request.getParameter("stdate");
		String eddate = request.getParameter("eddate");
		String status = request.getParameter("status");
		
		Connection conn;
		Statement st;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "UPDATE "+"SEMESTER"+" SET SEM = '"+semester+"' , YEAR = '"+year+"' , START_DATE = '"+stdate+"' , END_DATE = '"+eddate+"' , S_SEM_ID = '"+status+"' WHERE SEM = '"+semesters+"' AND YEAR = '"+years+"'";
			
			st = conn.createStatement();
			st.executeQuery(qr);
			
			response.setContentType("text/html");
			response.getWriter().print("SemesterView");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
