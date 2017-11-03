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
 * Servlet implementation class UsersUpdate
 */
@WebServlet("/UsersUpdate")
public class UsersUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdate() {
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
		String user_id = request.getParameter("user_id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String pos_id = request.getParameter("pos_id");
		String fac_id = request.getParameter("fac_id");
		String bra_name = request.getParameter("bra_name");
		String dep_id = request.getParameter("dep_id");
		String status = request.getParameter("status");
		
		Connection conn;
		Statement st;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "UPDATE "+"USERS"+" SET USERNAME = '"+username+"' , "
					+ "PASSWORD = '"+password+"' , "
					+ "FIRSTNAME = '"+firstname+"' , "
					+ "LASTNAME = '"+lastname+"' , "
					+ "P_ID = '"+pos_id+"' , "
					+ "FAC_ID = '"+fac_id+"' , "
					+ "BRA_NAME = '"+bra_name+"' , "
					+ "DEP_ID = '"+dep_id+"' , "
					+ "S_USER_ID = '"+status+"' "
					+ "WHERE USER_ID = '"+user_id+"'";
			
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
