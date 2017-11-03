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
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class UsersEdit
 */
@WebServlet("/UsersEdit")
public class UsersEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersEdit() {
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
		String id = request.getParameter("user_id");
		
		Users users = new Users();
		
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
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select u.user_id,u.username,u.password,u.firstname,u.lastname,p.p_id,p.p_name,f.fac_id,f.fac_name,b.bra_name,d.dep_id,d.dep_name,s.s_user_id,s.s_user_name "
					+ "from users u,position p,faculty f,branch b,department d,s_user s "
					+ "where u.p_id = p.p_id and u.fac_id = f.fac_id and u.bra_name = b.bra_name and u.dep_id = d.dep_id and u.s_user_id = s.s_user_id and u.user_id = '"+id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				users.setUserId(rs.getString("user_id"));
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				users.setFirstname(rs.getString("firstname"));
				users.setLastname(rs.getString("lastname"));
				users.setPosId(rs.getString("p_id"));
				users.setPosName(rs.getString("p_name"));
				users.setFacId(rs.getString("fac_id"));
				users.setFacName(rs.getString("fac_name"));
				users.setBraName(rs.getString("bra_name"));
				users.setDepId(rs.getString("dep_id"));
				users.setDepName(rs.getString("dep_name"));
				users.setStatusId(rs.getString("s_user_id"));
			}
			
			
			String qr1 = "select p_id,p_name,s_p_id from position where s_p_id = '001' order by p_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				position = new Position();
				position.setPid(rs.getString("p_id"));
				position.setPname(rs.getString("p_name"));
				position.setStatusId(rs.getString("s_p_id"));
				pos_list.add(position);
			}
			
			String qr2 = "select fac_id,fac_name,s_fbd_id from faculty where s_fbd_id = '001' order by fac_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				faculty = new Faculty();
				faculty.setFacId(rs.getString("fac_id"));
				faculty.setFacName(rs.getString("fac_name"));
				faculty.setStatusId(rs.getString("s_fbd_id"));
				fac_list.add(faculty);
			}
			
			String qr3 = "select dep_id,dep_name,s_fbd_id from department where s_fbd_id = '001' order by dep_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr3);
			
			while(rs.next()){
				department = new Department();
				department.setDepId(rs.getString("dep_id"));
				department.setDepName(rs.getString("dep_name"));
				department.setStatusId(rs.getString("s_fbd_id"));
				dep_list.add(department);
			}
			
			String qr4 = "select bra_name from branch where fac_id = '"+users.getFacId()+"' and s_fbd_id = '001'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr4);
			
			while(rs.next()){
				branch = new Branch();
				branch.setBranchName(rs.getString("bra_name"));
				bra_list.add(branch);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("usersedit", users);
			session.setAttribute("user_position", pos_list);
			session.setAttribute("user_faculty", fac_list);
			session.setAttribute("user_department", dep_list);
			session.setAttribute("user_branch", bra_list);
			
			response.setContentType("text/html");
			response.getWriter().print("usersedit.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
