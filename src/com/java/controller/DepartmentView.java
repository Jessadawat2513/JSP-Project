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
 * Servlet implementation class DepartmentView
 */
@WebServlet("/DepartmentView")
public class DepartmentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentView() {
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
		Department department;
		ArrayList<Department> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select dep_id ,dep_name,s_fbd_id from department order by dep_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				department = new Department();
				department.setDepId(rs.getString("dep_id"));
				department.setDepName(rs.getString("dep_name"));
				department.setStatusId(rs.getString("s_fbd_id"));
				list.add(department);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("departmentview", list);
			
			response.setContentType("text/html");
			response.getWriter().print("departmentview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
