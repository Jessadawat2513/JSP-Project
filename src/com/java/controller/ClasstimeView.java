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
 * Servlet implementation class ClasstimeView
 */
@WebServlet("/ClasstimeView")
public class ClasstimeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasstimeView() {
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
		Classtime classtime;
		ArrayList<Classtime> classtime_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select d.day_id,d.day_name,c.class_id,c.class_name , t.start_time , t.end_time from classtime t,day d,class c where t.class_id = c.class_id and t.day_id = d.day_id order by t.day_id,t.class_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				classtime = new Classtime();
				classtime.setDayId(rs.getString("day_id"));
				classtime.setDayName(rs.getString("day_name"));
				classtime.setClassId(rs.getString("class_id"));
				classtime.setClassName(rs.getString("class_name"));
				classtime.setStartTime(rs.getString("start_time"));
				classtime.setEndTime(rs.getString("end_time"));
				classtime_list.add(classtime);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("classtime_list", classtime_list);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("classtimeview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
