package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class BookingChange
 */
@WebServlet("/BookingChange")
public class BookingChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingChange() {
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
		String rm_num = request.getParameter("rm_num");
		
		Times time = null;
		Map<String, String> time_loop = new LinkedHashMap<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select starttime , endtime from room where rm_num = '"+rm_num+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			int index = 0;
			while(rs.next()){
				time = new Times();
				for(int i=Integer.parseInt(rs.getString("starttime").substring(0,2));i<=Integer.parseInt(rs.getString("endtime").substring(0,2));i++){
					for(int j=0;j<60;j+=10){
						if(i == Integer.parseInt(rs.getString("endtime").substring(0,2))){
							time_loop.put("time["+index+"]", time.FormatTime(i,j));
							break;
						}
						time_loop.put("time["+index+"]", time.FormatTime(i,j));
						index++;
					}
				}
			}
			
			String json = new Gson().toJson(time_loop);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
