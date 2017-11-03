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
 * Servlet implementation class SemesterAdd
 */
@WebServlet("/SemesterAdd")
public class SemesterAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterAdd() {
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
		String semester = request.getParameter("semester");
		String year = request.getParameter("year");
		String stdate = request.getParameter("stdate");
		String eddate = request.getParameter("eddate");
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "INSERT INTO "+"SEMESTER"+" (SEM_ID,YEAR,START_DATE,END_DATE,S_SEM_ID) VALUES ('"+semester+"','"+year+"','"+stdate+"','"+eddate+"','001')";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			response.setContentType("text/plain");
			response.getWriter().print("success");
			response.getWriter().close();
			
		}catch(SQLException ex){
			response.setContentType("text/plain");
			response.getWriter().print("fail");
			response.getWriter().close();
		}
	}

}
