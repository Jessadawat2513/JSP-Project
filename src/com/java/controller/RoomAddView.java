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
 * Servlet implementation class RoomAddView
 */
@WebServlet("/RoomAddView")
public class RoomAddView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomAddView() {
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
		Building building;
		ArrayList<Building> b_list = new ArrayList<>();
		
		Category category;
		ArrayList<Category> c_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select b_id,b_name from building";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				building = new Building();
				building.setBuildId(rs.getString("b_id"));
				building.setBuildName(rs.getString("b_name"));
				b_list.add(building);
			}
			
			String qr1 = "select cat_id,cat_name from category";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				category = new Category();
				category.setCatId(rs.getString("cat_id"));
				category.setCatName(rs.getString("cat_name"));
				c_list.add(category);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("building_list", b_list);
			session.setAttribute("category_list", c_list);
			
			response.setContentType("text/html");
			response.getWriter().print("roomadd.jsp");
			response.getWriter().close();
		}catch(SQLException ex){
			
		}
	}

}
