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
 * Servlet implementation class ScheduleChange
 */
@WebServlet("/ScheduleChange")
public class ScheduleChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleChange() {
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
		String semester = request.getParameter("semester");
		String building = request.getParameter("building");
		String room = request.getParameter("room");
		String action = request.getParameter("action");
		String json = null;
		
		Room rooms;
		ArrayList<Room> room_list = new ArrayList<>();
		
		Course course;
		ArrayList<Course> course_list = new ArrayList<>();
		
		Day day;
		ArrayList<Day> day_list = new ArrayList<>();
		
		Classes classes;
		ArrayList<Classes> class_list = new ArrayList<>();
		
		Teachstyle teachstyle;
		ArrayList<Teachstyle> t_style = new ArrayList<>();
		
		String t_div;
		ArrayList<String> t_div_id = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			switch(action){
			case "build_ch" :
								String qr = "select rm_num from room where b_id = '"+building+"' order by rm_num asc";
								
								st = conn.createStatement();
								rs = st.executeQuery(qr);
								
								while(rs.next()){
									rooms = new Room();
									rooms.setRoomNum(rs.getString("rm_num"));
									room_list.add(rooms);
								}
								json = new Gson().toJson(room_list);
								break;
			case "ShowOn_T" :
								String qr1 = "select s.c_code,c.c_name,s.day_id,s.class_id,t.teachname from schedule s,course c,teach_style t where s.c_code = c.c_code and t.teachid = s.teachid and s.sem_id = '"+semester.substring(0,3)+"' and s.year = '"+semester.substring(3)+"' and s.bk_id in (select bk_id from t_booking where rm_num = '"+room+"')";
								
								st = conn.createStatement();
								rs = st.executeQuery(qr1);
								
								while(rs.next()){
									t_div = new String();
									course = new Course();
									teachstyle = new Teachstyle();
									String day_id = rs.getString("day_id");
									String class_id = rs.getString("class_id");
									switch(day_id){
									case "001" : t_div = "sun"+class_id;break;
									case "002" : t_div = "mon"+class_id;break;
									case "003" : t_div = "tue"+class_id;break;
									case "004" : t_div = "wed"+class_id;break;
									case "005" : t_div = "thu"+class_id;break;
									case "006" : t_div = "fri"+class_id;break;
									case "007" : t_div = "sat"+class_id;break;
									}
									t_div_id.add(t_div);
									course.setCourseCode(rs.getString("c_code"));
									course.setCourseName(rs.getString("c_name"));
									teachstyle.setTeachName(rs.getString("teachname"));
									course_list.add(course);
									t_style.add(teachstyle);
								}
								String json1 = new Gson().toJson(course_list);
								String json2 = new Gson().toJson(t_style);
								String json3 = new Gson().toJson(t_div_id);
								json = "["+json1.toString()+","+json2.toString()+","+json3.toString()+"]";
								break;
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json.toString());
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
