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
 * Servlet implementation class RoomView
 */
@WebServlet("/RoomView")
public class RoomView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomView() {
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
		Room room;
		ArrayList<Room> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select r.rm_num,r.line,r.lps,r.seat,r.cat_id,c.cat_name,r.b_id,b.b_name,r.s_rm_id,s.s_rm_name from room r,category c,building b,s_room s where r.cat_id = c.cat_id and r.b_id = b.b_id and r.s_rm_id = s.s_rm_id order by r.rm_num asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				room = new Room();
				room.setRoomNum(rs.getString("rm_num"));
				room.setLine(rs.getString("line"));
				room.setLPS(rs.getString("lps"));
				room.setSeat(rs.getString("seat"));
				room.setCatId(rs.getString("cat_id"));
				room.setCatName(rs.getString("cat_name"));
				room.setBuildId(rs.getString("b_id"));
				room.setBuildName(rs.getString("b_name"));
				room.setStatusRoomId(rs.getString("s_rm_id"));
				room.setStatusRoomName(rs.getString("s_rm_name"));
				list.add(room);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("roomview", list);
			
			response.setContentType("text/html");
			response.getWriter().print("roomview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
