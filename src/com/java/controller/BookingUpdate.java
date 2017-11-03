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
 * Servlet implementation class BookingUpdate
 */
@WebServlet("/BookingUpdate")
public class BookingUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingUpdate() {
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
		String bk_id = request.getParameter("booking_id");
		String g_bk_no = request.getParameter("g_booking_no");
		String room_num = request.getParameter("roomid");
		String st_date = request.getParameter("st_date");
		String st_time = request.getParameter("st_time");
		String ed_date = request.getParameter("ed_date");
		String ed_time = request.getParameter("ed_time");
		
		Connection conn;
		Statement st;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "UPDATE "+"G_BOOKING"+" SET RM_NUM = '"+room_num+"',START_DATE = '"+st_date+"',END_DATE = '"+ed_date+"',START_TIME = '"+st_time+"',END_TIME = '"+ed_time+"' WHERE BK_ID = '"+bk_id+"' AND G_BK_NO = '"+g_bk_no+"'";
			
			st = conn.createStatement();
			st.executeQuery(qr);
			
			String qr1 = "UPDATE "+"QUEUE"+" SET RM_NUM = '"+room_num+"' WHERE BK_ID = '"+bk_id+"' AND G_BK_NO = '"+g_bk_no+"'";
			
			st = conn.createStatement();
			st.execute(qr1);
			
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
