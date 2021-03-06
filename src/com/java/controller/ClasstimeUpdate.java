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
 * Servlet implementation class ClasstimeUpdate
 */
@WebServlet("/ClasstimeUpdate")
public class ClasstimeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasstimeUpdate() {
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
		String day_id = request.getParameter("day_id");
		String class_id = request.getParameter("class_id");
		String day = request.getParameter("day");
		String classes = request.getParameter("classes");
		String st_time = request.getParameter("st_time");
		String ed_time = request.getParameter("ed_time");
		
		Connection conn;
		Statement st;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "UPDATE "+"CLASSTIME"+" SET DAY_ID = '"+day+"',CLASS_ID = '"+classes+"',START_TIME = '"+st_time+"',END_TIME = '"+ed_time+"' WHERE DAY_ID = '"+day_id+"' AND CLASS_ID = '"+class_id+"'";
			
			st = conn.createStatement();
			st.executeQuery(qr);
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("success");
			response.getWriter().close();
			
		}catch(SQLException ex){
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("fail");
			response.getWriter().close();
		}
	}

}
