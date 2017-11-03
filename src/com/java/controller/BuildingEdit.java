package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class BuildingEdit
 */
@WebServlet("/BuildingEdit")
public class BuildingEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuildingEdit() {
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
		String id = request.getParameter("ids");
		
		Building building = new Building();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select b_id,b_name,b_position,note,s_b_id from building where b_id = '"+id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				building.setBuildId(rs.getString("b_id"));
				building.setBuildName(rs.getString("b_name"));
				building.setBuildPosition(rs.getString("b_position"));
				building.setNote(rs.getString("note"));
				building.setStatusId(rs.getString("s_b_id"));
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("buildingedit", building);
			
			response.setContentType("text/html");
			response.getWriter().print("buildingedit.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
