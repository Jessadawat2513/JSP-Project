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
 * Servlet implementation class RoomAdd
 */
@WebServlet("/RoomAdd")
public class RoomAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomAdd() {
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
		String roomnum = request.getParameter("roomnum");
		String line = request.getParameter("line");
		String lps = request.getParameter("lps");
		String seat = request.getParameter("seat");
		String building = request.getParameter("building");
		String category = request.getParameter("category");
		
		Connection conn;
		Statement st;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "INSERT INTO "+"ROOM"+" (RM_NUM,LINE,LPS,SEAT,CAT_ID,B_ID,S_RM_ID) VALUES ('"+roomnum+"','"+line+"','"+lps+"','"+seat+"','"+category+"','"+building+"','001')";
			
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
