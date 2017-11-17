package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class CoursedetailAdd
 */
@WebServlet("/CoursedetailAdd")
public class CoursedetailAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursedetailAdd() {
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
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select substr('"+semester+"',1,3) as semester , substr('"+semester+"',4,4) as year from dual";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				for(String data : course){
					String qr1 = "INSERT INTO "+"D_COURSE"+" (C_CODE,SEM_ID,YEAR) VALUES ('"+data+"','"+rs.getString("semester")+"','"+rs.getString("year")+"')";
					
					st = conn.createStatement();
					st.executeQuery(qr1);
					
					String qr2 = "UPDATE "+"COURSE"+" SET S_C_ID = '001' WHERE S_C_ID = '002' AND C_CODE = '"+data+"'";
					st = conn.createStatement();
					st.execute(qr2);
					
					String qr3 = "UPDATE "+"SEMESTER"+" SET S_SEM_ID = '001' WHERE S_SEM_ID = '002' AND SEM_ID = '"+rs.getString("semester")+"' AND YEAR = '"+rs.getString("year")+"'";
					st = conn.createStatement();
					st.execute(qr3);
				}
			}
			
			
			
			response.setContentType("text/plain");
			response.getWriter().write("success");
			response.getWriter().close();
			
		}catch(SQLException ex){
			response.setContentType("text/plain");
			response.getWriter().write("fail");
			response.getWriter().close();
		}
	}

}
