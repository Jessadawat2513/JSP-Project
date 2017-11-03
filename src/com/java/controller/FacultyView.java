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
 * Servlet implementation class FacultyView
 */
@WebServlet("/FacultyView")
public class FacultyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyView() {
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
		
		Faculty faculty;
		ArrayList<Faculty> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select fac_id ,fac_name ,s_fbd_id from faculty order by fac_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				faculty = new Faculty();
				faculty.setFacId(rs.getString("fac_id"));
				faculty.setFacName(rs.getString("fac_name"));
				faculty.setStatusId(rs.getString("s_fbd_id"));
				list.add(faculty);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("facultyview", list);
			
			response.setContentType("text/html");
			response.getWriter().print("facultyview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
