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
 * Servlet implementation class BookingDetail
 */
@WebServlet("/BookingDetail")
public class BookingDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingDetail() {
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
		String room_id = request.getParameter("room_id");
		
		Users users = new Users();
		Room room = new Room();
		
		G_booking g_booking;
		ArrayList<G_booking> g_booking_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select g.bk_id,g.g_bk_no,g.rm_num,g.start_date,g.end_date,g.start_time,g.end_time,u.firstname,u.lastname,s.s_bk_name "
					+ "from booking b,g_booking g,users u,s_booking s "
					+ "where u.user_id = b.user_id and g.bk_id = b.bk_id and s.s_bk_id = g.s_bk_id and rm_num = '"+room_id+"' "
					+ "order by bk_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				g_booking = new G_booking();
				g_booking.setBookingId(rs.getString("bk_id"));
				g_booking.setG_BookingNo(rs.getString("g_bk_no"));
				g_booking.setRoomNum(rs.getString("rm_num"));
				g_booking.setStartDate(rs.getString("start_date"));
				g_booking.setEndDate(rs.getString("end_date"));
				g_booking.setStartTime(rs.getString("start_time"));
				g_booking.setEndTime(rs.getString("end_time"));
				g_booking.setFirstname(rs.getString("firstname"));
				g_booking.setLastname(rs.getString("lastname"));
				g_booking.setStatusName(rs.getString("s_bk_name"));
				g_booking_list.add(g_booking);
			}
			
			rs.close();
			st.close();
			
			String qr1 = "select u.firstname,u.lastname,p.p_name,f.fac_name,u.bra_name,d.dep_name "
					+ "from users u,position p,faculty f,branch b,department d "
					+ "where u.p_id = p.p_id and u.fac_id = f.fac_id and u.bra_name = b.bra_name and u.dep_id = d.dep_id and u.user_id = '"+user_id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				users.setFirstname(rs.getString("firstname"));
				users.setLastname(rs.getString("lastname"));
				users.setPosName(rs.getString("p_name"));
				users.setFacName(rs.getString("fac_name"));
				users.setBraName(rs.getString("bra_name"));
				users.setDepName(rs.getString("dep_name"));
			}
			
			rs.close();
			st.close();
			
			String qr2 = "select r.rm_num,r.seat,c.cat_name,b.b_name from room r,category c,building b where r.cat_id = c.cat_id and r.b_id = b.b_id and r.rm_num = '"+room_id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				room.setRoomNum(rs.getString("rm_num"));
				room.setSeat(rs.getString("seat"));
				room.setCatName(rs.getString("cat_name"));
				room.setBuildName(rs.getString("b_name"));
			}
			
			rs.close();
			st.close();
			
			HttpSession session = request.getSession();
			session.setAttribute("user_view", users);
			session.setAttribute("room_view", room);
			session.setAttribute("g_booking_list", g_booking_list);
			
		}catch(SQLException ex){
			
		}
	}

}
