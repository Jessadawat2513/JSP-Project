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
 * Servlet implementation class UsersAddView
 */
@WebServlet("/UsersAddView")
public class UsersAddView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersAddView() {
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
		Position position;
		ArrayList<Position> pos_list = new ArrayList<>();
		
		Faculty faculty;
		ArrayList<Faculty> fac_list = new ArrayList<>();
		
		Branch branch;
		ArrayList<Branch> bra_list = new ArrayList<>();
		
		Department department;
		ArrayList<Department> dep_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs,rs1;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select p_id,p_name,s_p_id from position order by p_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				position = new Position();
				position.setPid(rs.getString("p_id"));
				position.setPname(rs.getString("p_name"));
				position.setStatusId(rs.getString("s_p_id"));
				pos_list.add(position);			
			}
			
			String qr1 = "select fac_id,fac_name,s_fbd_id from faculty order by fac_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				faculty = new Faculty();
				faculty.setFacId(rs.getString("fac_id"));
				faculty.setFacName(rs.getString("fac_name"));
				faculty.setStatusId(rs.getString("s_fbd_id"));
				fac_list.add(faculty);
			}
			
			String qr2 = "select dep_id,dep_name,s_fbd_id from department order by dep_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				department = new Department();
				department.setDepId(rs.getString("dep_id"));
				department.setDepName(rs.getString("dep_name"));
				department.setStatusId(rs.getString("s_fbd_id"));
				dep_list.add(department);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("user_position", pos_list);
			session.setAttribute("user_faculty", fac_list);
			session.setAttribute("user_department", dep_list);
			
			response.setContentType("text/html");
			response.getWriter().print("usersadd.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
