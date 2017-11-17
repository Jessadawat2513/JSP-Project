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
 * Servlet implementation class CoursedetailChange
 */
@WebServlet("/CoursedetailChange")
public class CoursedetailChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursedetailChange() {
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
		
		int i = 0;
		
		Coursedetail coursedetail;
		ArrayList<Coursedetail> cd_list = new ArrayList<>();
		
		Map<String, String> data = new LinkedHashMap<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select substr('"+semester+"',1,3) as semester , substr('"+semester+"',4,4) as year from dual";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				String qr1 = "select d.c_code,c.c_name from d_course d,course c where d.c_code = c.c_code and d.sem_id = '"+rs.getString("semester")+"' and d.year = '"+rs.getString("year")+"'";
				
				st = conn.createStatement();
				rs = st.executeQuery(qr1);
				
				while(rs.next()){
					String text = rs.getString("c_code")+" | "+rs.getString("c_name");
					data.put(rs.getString("c_code"), text);
					i++;
				}
				i++;
			}

			String json = new Gson().toJson(data);
			
			if(i>1){
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				response.getWriter().close();
			}else{
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("null");
				response.getWriter().close();
			}
			
		}catch(SQLException ex){
			
		}
	}

}
