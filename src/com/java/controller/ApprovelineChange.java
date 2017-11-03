package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class ApprovelineChange
 */
@WebServlet("/ApprovelineChange")
public class ApprovelineChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovelineChange() {
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
		String action = request.getParameter("action");
		String ap_id = request.getParameter("ap_value");
		String position = request.getParameter("position");
		String ap_line = request.getParameter("ap_line");
		
		Map<String, String > data = new LinkedHashMap<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();

			String qr = "select o.p_id,p.p_name from o_approve o,position p where p.p_id = o.p_id and o.d_ap_id = '"+ap_id+"' order by indexs asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				data.put(rs.getString("p_id"), rs.getString("p_name"));
			}
			
			String json = new Gson().toJson(data);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();

		}catch(SQLException ex){
			
		}
	}

}
