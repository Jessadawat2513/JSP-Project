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
 * Servlet implementation class FacultyUpdate
 */
@WebServlet("/FacultyUpdate")
public class FacultyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyUpdate() {
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
		String id = request.getParameter("ids");
		String facname = request.getParameter("facname");
		String status = request.getParameter("status");
		
		Connection conn;
		Statement st;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "UPDATE "+"FACULTY"+" SET FAC_NAME =  '"+facname+"' , S_FBD_ID = '"+status+"' WHERE FAC_ID = '"+id+"'";
			
			st = conn.createStatement();
			st.executeQuery(qr);
			
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
