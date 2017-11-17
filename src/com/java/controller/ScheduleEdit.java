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
 * Servlet implementation class ScheduleEdit
 */
@WebServlet("/ScheduleEdit")
public class ScheduleEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleEdit() {
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
		String day_id = request.getParameter("day_id");
		String class_id = request.getParameter("cl_id");
		String semester = request.getParameter("semester");
		String course = request.getParameter("course");
		
		Map<String, String> data = new LinkedHashMap<>();
		int i = 0;
		boolean day_st = false;
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select rm_num from room order by rm_num asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			i = 0;
			while(rs.next()){
				data.put("room["+i+"]", rs.getString("rm_num"));
				i++;
			}
			
			String qr1 = "select s.sem_id,d.sem_name,s.year from semester s,d_semester d where s.sem_id = d.sem_id order by s.sem_id,s.year asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			i = 0;
			while(rs.next()){
				data.put("semesterId["+i+"]",rs.getString("sem_id"));
				data.put("semesterName["+i+"]",rs.getString("sem_name"));
				data.put("semesterYear["+i+"]",rs.getString("year"));
				i++;
			}
			
			String qr2 = "select day_id,day_name from day order by day_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			i = 0;
			while(rs.next()){
				data.put("dayId["+i+"]", rs.getString("day_id"));
				data.put("dayName["+i+"]", rs.getString("day_name"));
				i++;
			}
			
			String qr3 = "select ct.class_id,cl.class_name from classtime ct,class cl where ct.class_id = cl.class_id and day_id = '"+day_id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr3);
			i = 0;
			while(rs.next()){
				day_st = true;
				data.put("classId["+i+"]", rs.getString("class_id"));
				data.put("className["+i+"]", rs.getString("class_name"));
				i++;
			}
			
			String qr4 = "select d.c_code,c.c_name from d_course d,course c where d.c_code = c.c_code and d.sem_id = '"+semester.substring(0,3)+"' and d.year = '"+semester.substring(3)+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr4);
			i = 0;
			while(rs.next()){
				data.put("courseCode["+i+"]", rs.getString("c_code"));
				data.put("courseName["+i+"]", rs.getString("c_name"));
				i++;
			}
			
			String qr5 = "select teachid from schedule where sem_id = '"+semester.substring(0,3)+"' and year = '"+semester.substring(3)+"' and c_code = '"+course+"' and class_id = '"+class_id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr5);
			
			while(rs.next()){
				data.put("teachID", rs.getString("teachid"));
			}
			
			if(day_st){
				data.put("Status", Boolean.toString(day_st));
			}else{
				data.put("Status", Boolean.toString(day_st));
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
