package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;

import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class BookingHistory
 */
@WebServlet("/BookingHistory")
public class BookingHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingHistory() {
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
		
		G_booking g_booking;
		ArrayList<G_booking> g_booking_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select b.bk_id,g.g_bk_no,g.rm_num,s.s_bk_name,g.start_date,g.start_time,g.end_date,g.end_time from booking b,g_booking g,s_booking s where g.bk_id = b.bk_id and s.s_bk_id = g.s_bk_id and b.user_id = '"+user_id+"' order by substr(b.bk_id,9,4) asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				g_booking = new G_booking();
				g_booking.setBookingId(rs.getString("bk_id"));
				g_booking.setG_BookingNo(rs.getString("g_bk_no"));
				g_booking.setRoomNum(rs.getString("rm_num"));
				g_booking.setStartDate(rs.getString("start_date"));
				g_booking.setStartTime(rs.getString("start_time"));
				g_booking.setEndDate(rs.getString("end_date"));
				g_booking.setEndTime(rs.getString("end_time"));
				g_booking.setStatusName(rs.getString("s_bk_name"));
				g_booking_list.add(g_booking);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("g_booking_list", g_booking_list);
			
		}catch(SQLException ex){
			
		}
	}

}
