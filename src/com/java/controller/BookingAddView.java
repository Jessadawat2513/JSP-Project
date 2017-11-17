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
 * Servlet implementation class BookingAddView
 */
@WebServlet("/BookingAddView")
public class BookingAddView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingAddView() {
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
		String room_num = request.getParameter("room_val");
		
		String room_select = room_num;
		Room room;
		ArrayList<Room> room_list = new ArrayList<>();
		
		Semester semester;
		ArrayList<Semester> sem_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			if(room_select.equals("null")){

				String qr = "select rm_num from room order by rm_num asc";
				
				st = conn.createStatement();
				rs = st.executeQuery(qr);
				
				while(rs.next()){
					room = new Room();
					room.setRoomNum(rs.getString("rm_num"));
					room_list.add(room);
				}
				
				String qr1 = "select s.sem_id ,d.sem_name,s.year from semester s,d_semester d where s.sem_id = d.sem_id order by s.year asc";
				
				st = conn.createStatement();
				rs = st.executeQuery(qr1);
				
				while(rs.next()){
					semester = new Semester();
					semester.setSemesterId(rs.getString("sem_id"));
					semester.setSemesterName(rs.getString("sem_name"));
					semester.setYear(rs.getString("year"));
					sem_list.add(semester);
				}
			}else{

				String qr = "select rm_num,starttime,endtime from room where s_rm_id = '001' and rm_num = '"+room_select+"' order by rm_num asc";
				
				st = conn.createStatement();
				rs = st.executeQuery(qr);
				
				while(rs.next()){
					room = new Room();
					room.setRoomNum(rs.getString("rm_num"));
					System.out.println(rs.getString("starttime"));
					System.out.println(rs.getString("endtime"));
					room_list.add(room);
				}
			}
			
			
			HttpSession session = request.getSession();
			session.setAttribute("room_list", room_list);
			session.setAttribute("room_select", room_select);
			session.setAttribute("sem_list", sem_list);
			
		}catch(SQLException ex){
			
		}
	}

}
