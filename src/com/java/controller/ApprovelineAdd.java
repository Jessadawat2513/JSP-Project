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
 * Servlet implementation class ApprovelineAdd
 */
@WebServlet("/ApprovelineAdd")
public class ApprovelineAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovelineAdd() {
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
		String ap_value = request.getParameter("ap_value");
		String[] Ap_line = request.getParameterValues("Select[]");
		
		int i = 1;
		
		Connection conn;
		Statement st;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "DELETE FROM "+"O_APPROVE"+" WHERE D_AP_ID = '"+ap_value+"'";
			
			st = conn.createStatement();
			st.execute(qr);
			for(String data : Ap_line){

				String qr1 = "INSERT INTO "+"O_APPROVE"+" (D_AP_ID,P_ID,INDEXS) VALUES ('"+ap_value+"','"+data+"','"+i+"')";
				
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
