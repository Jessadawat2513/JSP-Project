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

import com.java.model.*;
import com.java.controller.*;

/**
 * Servlet implementation class BookingEdit
 */
@WebServlet("/BookingEdit")
public class BookingEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingEdit() {
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
		String room_num = request.getParameter("room_id");
		String bk_id = request.getParameter("booking_id");
		String g_bk_no = request.getParameter("g_booking_no");
		
		G_booking g_booking = new G_booking();
		
		Room room;
		ArrayList<Room> room_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select bk_id,rm_num,g_bk_no,start_date,end_date,start_time,end_time from g_booking where bk_id = '"+bk_id+"' and g_bk_no = '"+g_bk_no+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				g_booking.setBookingId(rs.getString("bk_id"));
				g_booking.setRoomNum(rs.getString("rm_num"));
				g_booking.setG_BookingNo(rs.getString("g_bk_no"));
				g_booking.setStartDate(rs.getString("start_date"));
				g_booking.setEndDate(rs.getString("end_date"));
				g_booking.setStartTime(rs.getString("start_time"));
				g_booking.setEndTime(rs.getString("end_time"));
			}
			
			String qr1 = "select rm_num from room order by rm_num asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				room = new Room();
				room.setRoomNum(rs.getString("rm_num"));
				room_list.add(room);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("g_booking_edit", g_booking);
			session.setAttribute("room_list", room_list);
			
		}catch(SQLException ex){
			
		}
	}

}
