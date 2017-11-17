	package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class BookingSearch
 */
@WebServlet("/BookingSearch")
public class BookingSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingSearch() {
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
		String category = request.getParameter("category");
		String building = request.getParameter("building");	
		
		Room room;
		List<Room> room_list = new LinkedList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			if(category.equals("000") && building.equals("000")){
				String qr = "select r.rm_num,r.seat,c.cat_name,s.s_rm_name from room r,category c,s_room s where r.cat_id = c.cat_id and s.s_rm_id = r.s_rm_id order by rm_num asc";
				st = conn.createStatement();
				rs = st.executeQuery(qr);
			}else if(!(category.equals("000")) && building.equals("000")){
				String qr = "select r.rm_num,r.seat,c.cat_name,s.s_rm_name from room r,category c,s_room s where r.cat_id = c.cat_id and s.s_rm_id = r.s_rm_id and r.cat_id = '"+category+"' order by rm_num asc";
				st = conn.createStatement();
				rs = st.executeQuery(qr);
			}else if(!(building.equals("000")) && category.equals("000")){
				String qr = "select r.rm_num,r.seat,c.cat_name,s.s_rm_name from room r,category c,s_room s where r.cat_id = c.cat_id and s.s_rm_id = r.s_rm_id and r.b_id = '"+building+"' order by rm_num asc";
				st = conn.createStatement();
				rs = st.executeQuery(qr);
			}else{
				String qr = "select r.rm_num,r.seat,c.cat_name,s.s_rm_name from room r,category c,s_room s where r.cat_id = c.cat_id and s.s_rm_id = r.s_rm_id and r.cat_id = '"+category+"' and r.b_id = '"+building+"' order by rm_num asc";
				st = conn.createStatement();
				rs = st.executeQuery(qr);
			}

			while(rs.next()){
				room = new Room();
				room.setRoomNum(rs.getString("rm_num"));
				room.setSeat(rs.getString("seat"));
				room.setCatName(rs.getString("cat_name"));
				room.setStatusRoomName(rs.getString("s_rm_name"));
				room_list.add(room);
			}
			
			String json = new Gson().toJson(room_list);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
