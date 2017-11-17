package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class CoursedetailUpdate
 */
@WebServlet("/CoursedetailUpdate")
public class CoursedetailUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursedetailUpdate() {
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
		String[] course = request.getParameterValues("Select[]");
		
		System.out.println(semester);
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select substr('"+semester+"',1,3) as semester , substr('"+semester+"',4,4) as year from dual";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				String sem_id = rs.getString("semester");
				String year = rs.getString("year");
				
				String qr1 = "DELETE FROM "+"D_COURSE"+" WHERE SEM_ID = '"+sem_id+"' AND YEAR = '"+year+"'";
				st = conn.createStatement();
				st.execute(qr1);
				
				for(String data : course){
					String qr0 = "UPDATE "+"COURSE"+" SET S_C_ID = '002' WHERE S_C_ID = '001'";
					st = conn.createStatement();
					st.execute(qr0);
					
					String qr2 = "INSERT INTO "+"D_COURSE"+" (C_CODE,SEM_ID,YEAR) VALUES ('"+data+"','"+sem_id+"','"+year+"')";
					st = conn.createStatement();
					st.execute(qr2);
					
					String qr3 = "UPDATE "+"COURSE"+" SET S_C_ID = '001' WHERE S_C_ID = '002' AND C_CODE = '"+data+"'";
					st = conn.createStatement();
					st.execute(qr3);
					
					String qr4 = "UPDATE "+"SEMESTER"+" SET S_SEM_ID = '001' WHERE S_SEM_ID = '002' AND SEM_ID = '"+rs.getString("semester")+"' AND YEAR = '"+rs.getString("year")+"'";
					st = conn.createStatement();
					st.execute(qr4);
				}
			}
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("success");
			response.getWriter().close();
			
		}catch(SQLException ex){
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println("fail");
			response.getWriter().close();
		}
	}

}
