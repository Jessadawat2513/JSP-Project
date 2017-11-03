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
 * Servlet implementation class ClasstimeEdit
 */
@WebServlet("/ClasstimeEdit")
public class ClasstimeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClasstimeEdit() {
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
		String day_id = request.getParameter("day_id");
		String class_id = request.getParameter("class_id");
		
		Classtime classtime = new Classtime();
		
		Classes classes;
		ArrayList<Classes> classes_list = new ArrayList<>();
		
		Day day;
		ArrayList<Day> day_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select day_id,class_id,start_time,end_time from classtime where day_id = '"+day_id+"' and class_id = '"+class_id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				classtime.setDayId(rs.getString("day_id"));
				classtime.setClassId(rs.getString("class_id"));
				classtime.setStartTime(rs.getString("start_time"));
				classtime.setEndTime(rs.getString("end_time"));
			}
			
			String qr1 = "select day_id,day_name from day order by day_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				day = new Day();
				day.setDayId(rs.getString("day_id"));
				day.setDayName(rs.getString("day_name"));
				day_list.add(day);
			}
			
			String qr2 = "select class_id,class_name from class where s_cl_id = '001' order by class_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				classes = new Classes();
				classes.setClassId(rs.getString("class_id"));
				classes.setClassName(rs.getString("class_name"));
				classes_list.add(classes);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("classtime_edit", classtime);
			session.setAttribute("day_list", day_list);
			session.setAttribute("classes_list", classes_list);
			
		}catch(SQLException ex){
			
		}
	}

}
