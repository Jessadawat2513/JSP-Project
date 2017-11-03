package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.java.model.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.java.controller.*;

/**
 * Servlet implementation class PositionView
 */
@WebServlet("/PositionView")
public class PositionView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PositionView() {
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
		Position position;
		ArrayList<Position> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select p_id,p_name,s_p_id from position order by p_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				position = new Position();
				position.setPid(rs.getString("p_id"));
				position.setPname(rs.getString("p_name"));
				position.setStatusId(rs.getString("s_p_id"));
				list.add(position);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("positionview", list);
			
			response.setContentType("text/html");
			response.getWriter().print("positionview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
