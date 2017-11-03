package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class BookingAdd
 */
@WebServlet("/BookingAdd")
public class BookingAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingAdd() {
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
		String room_id = request.getParameter("roomid");
		String st_date = request.getParameter("st_date");
		String ed_date = request.getParameter("ed_date");
		String st_time = request.getParameter("st_time");
		String ed_time = request.getParameter("ed_time");
		int no = 1;
		
		Connection conn;
		Statement  st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "INSERT INTO "+"BOOKING"+" (BK_ID,USER_ID,BK_DATE,BK_TIME) "
					+ "VALUES ((select to_char(sysdate,'DDMMYYYY') || lpad(max(nvl(substr(bk_id,9,4),'0'))+1,4,'0') from booking),"
					+ "'"+user_id+"',"
					+ "(select to_char(sysdate,'YYYY-MM-DD') from dual),"
					+ "(select to_char(sysdate,'HH24:MI') from dual))";
			
			st = conn.createStatement();
			st.executeQuery(qr);
			
			String qr1 = "INSERT INTO "+"G_BOOKING"+" (BK_ID,G_BK_NO,RM_NUM,START_DATE,END_DATE,START_TIME,END_TIME,S_BK_ID) "
					+ "VALUES ((select to_char(sysdate,'DDMMYYYY') || lpad(max(nvl(substr(bk_id,9,4),'0')),4,'0') from booking),"
					+ "'"+no+"','"+room_id+"','"+st_date+"','"+ed_date+"','"+st_time+"','"+ed_time+"','002')";
			
			st = conn.createStatement();
			st.execute(qr1);
			
			String qr2 = "INSERT INTO "+"QUEUE"+" (BK_ID,G_BK_NO,RM_NUM,Q_NO,S_BK_ID) "
					+ "VALUES ((select to_char(sysdate,'DDMMYYYY') || lpad(max(nvl(substr(bk_id,9,4),'0')),4,'0') from booking),"
					+ "(select G_BK_NO from g_booking where rm_num = '"+room_id+"' and bk_id = (select to_char(sysdate,'DDMMYYYY') || lpad(max(nvl(substr(bk_id,9,4),'0')),4,'0') from booking)),"
					+ "'"+room_id+"',(select nvl(max(Q_NO),'0')+1 as Q_NO from queue where RM_NUM = '"+room_id+"'),'002')";
			
			st = conn.createStatement();
			st.execute(qr2);
			
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
