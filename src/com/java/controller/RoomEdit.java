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
 * Servlet implementation class RoomEdit
 */
@WebServlet("/RoomEdit")
public class RoomEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomEdit() {
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
		String roomnum = request.getParameter("room_num");
		
		Room room = new Room();
		
		Building building;
		ArrayList<Building> building_list = new ArrayList<>();
		
		Category category;
		ArrayList<Category> category_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select r.rm_num,r.line,r.lps,r.cat_id,c.cat_name,r.b_id,b.b_name,r.s_rm_id from room r,building b,category c where r.cat_id = c.cat_id and r.b_id = b.b_id and rm_num = '"+roomnum+"'";
			
			st = conn.createStatement();
			rs= st.executeQuery(qr);
			
			while(rs.next()){
				room.setRoomNum(rs.getString("rm_num"));
				room.setLine(rs.getString("line"));
				room.setLPS(rs.getString("lps"));
				room.setCatId(rs.getString("cat_id"));
				room.setCatName(rs.getString("cat_name"));
				room.setBuildId(rs.getString("b_id"));
				room.setBuildName(rs.getString("b_name"));
				room.setStatusRoomId(rs.getString("s_rm_id"));
			}
			
			String qr1 = "select b_id,b_name from building where s_b_id = '001'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				building = new Building();
				building.setBuildId(rs.getString("b_id"));
				building.setBuildName(rs.getString("b_name"));
				building_list.add(building);
			}
			
			String qr2 = "select cat_id,cat_name from category where s_cat_id = '001'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				category = new Category();
				category.setCatId(rs.getString("cat_id"));
				category.setCatName(rs.getString("cat_name"));
				category_list.add(category);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("roomedit", room);
			session.setAttribute("building_list", building_list);
			session.setAttribute("category_list", category_list);
			
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
