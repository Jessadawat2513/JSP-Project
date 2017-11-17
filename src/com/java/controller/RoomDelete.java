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
 * Servlet implementation class RoomDelete
 */
@WebServlet("/RoomDelete")
public class RoomDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomDelete() {
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
		String category = null;
		String building = null;
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select cat_id,b_id from room where rm_num = '"+roomnum+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			while(rs.next()){
				category = rs.getString("cat_id");
				building = rs.getString("b_id");
			}
			
			String qr1 = "DELETE FROM "+"ROOM"+" WHERE RM_NUM = '"+roomnum+"'";
			
			st = conn.createStatement();
			st.executeQuery(qr1);
			
			String qr2 = "select count(cat_id) as count from room where cat_id = '"+category+"'";
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			while(rs.next()){
				if(rs.getString("count").equals("0")){
					String qr0 = "UPDATE "+"CATEGORY"+" SET S_CAT_ID = '002' WHERE CAT_ID = '"+category+"' AND S_CAT_ID = '001'";
					st = conn.createStatement();
					st.execute(qr0);
				}
			}
			
			String qr3 = "select count(b_id) as count from room where b_id = '"+building+"'";
			st = conn.createStatement();
			rs = st.executeQuery(qr3);
			while(rs.next()){
				if(rs.getString("count").equals("0")){
					String qr0 = "UPDATE "+"BUILDING"+" SET S_B_ID = '002' WHERE B_ID = '"+building+"' AND S_B_ID = '001'";
					st = conn.createStatement();
					st.execute(qr0);
				}
			}
			
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
