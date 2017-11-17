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
 * Servlet implementation class ScheduleAddView
 */
@WebServlet("/ScheduleAddView")
public class ScheduleAddView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAddView() {
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
		String semester = request.getParameter("semester");
		String day_id = request.getParameter("day");
		
		Semester semesters;
		ArrayList<Semester> sem_list = new ArrayList<>();
		
		Room room;
		ArrayList<Room> room_list = new ArrayList<>();
		
		Day day;
		ArrayList<Day> day_list = new ArrayList<>();
		
		Course course;
		ArrayList<Course> course_list = new ArrayList<>();
		
		Classes classes;
		ArrayList<Classes> classes_list = new ArrayList<>();
		
		String json_list = null;
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			switch(action){
			case "ShowView" :	
								String qr = "select rm_num from room";
								
								st = conn.createStatement();
								rs = st.executeQuery(qr);
								while(rs.next()){
									room = new Room();
									room.setRoomNum(rs.getString("rm_num"));
									room_list.add(room);
								}
								
								String qr3 = "select s.sem_id,d.sem_name,s.year from semester s,d_semester d where s.sem_id = d.sem_id order by s.sem_id,s.year asc";
								
								st = conn.createStatement();
								rs = st.executeQuery(qr3);
								while(rs.next()){
									semesters = new Semester();
									semesters.setSemesterId(rs.getString("sem_id"));
									semesters.setSemesterName(rs.getString("sem_name"));
									semesters.setYear(rs.getString("year"));
									sem_list.add(semesters);
								}
								
								String qr4 = "select day_id,day_name from day order by day_id asc";
								
								st = conn.createStatement();
								rs = st.executeQuery(qr4);
								while(rs.next()){
									day = new Day();
									day.setDayId(rs.getString("day_id"));
									day.setDayName(rs.getString("day_name"));
									day_list.add(day);
								}
								String json = new Gson().toJson(sem_list);
								String json1 = new Gson().toJson(room_list);
								String json2 = new Gson().toJson(day_list);
								json_list = "["+json.toString()+","+json1.toString()+","+json2.toString()+"]";
								break;
			case "ChangeCourse" :
								String qr1 = "select d.c_code,c.c_name from d_course d,course c where d.c_code = c.c_code and d.sem_id = '"+semester.substring(0,3)+"' and d.year = '"+semester.substring(3)+"'";
								
								st = conn.createStatement();
								rs = st.executeQuery(qr1);
								while(rs.next()){
									course = new Course();
									course.setCourseCode(rs.getString("c_code"));
									course.setCourseName(rs.getString("c_name"));
									course_list.add(course);
								}
								json_list = new Gson().toJson(course_list);
								break;
			case "ChangeDay" :
								String qr2 = "select cl.class_id,cl.class_name from classtime ct,class cl where ct.class_id = cl.class_id and day_id = '"+day_id+"' order by ct.day_id,ct.class_id asc";
								
								st = conn.createStatement();
								rs = st.executeQuery(qr2);
								while(rs.next()){
									classes = new Classes();
									classes.setClassId(rs.getString("class_id"));
									classes.setClassName(rs.getString("class_name"));
									classes_list.add(classes);
								}
								json_list = new Gson().toJson(classes_list);
								break;
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json_list.toString());
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
