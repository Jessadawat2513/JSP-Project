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
 * Servlet implementation class BookingView
 */
@WebServlet("/BookingView")
public class BookingView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingView() {
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
		Category category;
		ArrayList<Category> cat_list = new ArrayList<>();
		
		Building building;
		ArrayList<Building> b_list = new ArrayList<>();
		
		Room room;
		ArrayList<Room> rm_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select cat_id,cat_name from category";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				category = new Category();
				category.setCatId(rs.getString("cat_id"));
				category.setCatName(rs.getString("cat_name"));
				cat_list.add(category);
			}
			
			String qr1 = "select b_id,b_name from building where s_b_id = '001' order by b_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				building = new Building();
				building.setBuildId(rs.getString("b_id"));
				building.setBuildName(rs.getString("b_name"));
				b_list.add(building);
			}
			
			String qr2 = "select r.rm_num,r.seat,c.cat_name,b.b_name,s.s_rm_name from room r,category c,building b,s_room s where r.cat_id = c.cat_id and r.b_id = b.b_id and r.s_rm_id = s.s_rm_id and r.s_rm_id = '001'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				room = new Room();
				room.setRoomNum(rs.getString("rm_num"));
				room.setSeat(rs.getString("seat"));
				room.setCatName(rs.getString("cat_name"));
				room.setBuildName(rs.getString("b_name"));
				room.setStatusRoomName(rs.getString("s_rm_name"));
				rm_list.add(room);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("category_list", cat_list);
			session.setAttribute("building_list", b_list);
			session.setAttribute("room_list", rm_list);
			
			response.setContentType("text/html");
			response.getWriter().print("bookingview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
