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
 * Servlet implementation class SemesterView
 */
@WebServlet("/SemesterView")
public class SemesterView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterView() {
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
		Semester semester;
		ArrayList<Semester> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select s.sem_id,d.sem_name,s.year,s.start_date,s.end_date,s.s_sem_id from semester s,d_semester d where s.sem_id = d.sem_id order by s.sem_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				semester = new Semester();
				semester.setSemesterId(rs.getString("sem_id"));
				semester.setSemesterName(rs.getString("sem_name"));
				semester.setYear(rs.getString("year"));
				semester.setStartdate(rs.getString("start_date"));
				semester.setEnddate(rs.getString("end_date"));
				semester.setStatusId(rs.getString("s_sem_id"));
				list.add(semester);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("semesterview", list);
			
			response.setContentType("text/html");
			response.getWriter().print("semesterview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
