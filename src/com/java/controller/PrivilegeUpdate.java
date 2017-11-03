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
 * Servlet implementation class PrivilegeUpdate
 */
@WebServlet("/PrivilegeUpdate")
public class PrivilegeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrivilegeUpdate() {
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
		String position = request.getParameter("pos_select");
		String[] privilege = request.getParameterValues("Privilege[]");
		String[] status = request.getParameterValues("Status[]");
		int i = 0;
		
		System.out.println(position);
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "DELETE FROM "+"M_PRIVILEGE"+" WHERE P_ID = '"+position+"'";
			
			st = conn.createStatement();
			st.execute(qr);
			
			i = 0;
			
			for(String data : privilege){				
				String qr1 = "INSERT INTO "+"M_PRIVILEGE"+" (P_ID,PRI_ID,S_PRI_ID) VALUES ('"+position+"','"+data+"','"+status[i]+"')";
				
				st = conn.createStatement();
				st.executeQuery(qr1);
				
				i++;
			}
			
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
