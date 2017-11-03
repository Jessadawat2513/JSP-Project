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
 * Servlet implementation class UsersView
 */
@WebServlet("/UsersView")
public class UsersView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersView() {
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
		Users users;
		ArrayList<Users> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select u.user_id,u.username,u.password,u.firstname,u.lastname,"
					+ "p.p_id,p.p_name,"
					+ "f.fac_id,f.fac_name,"
					+ "b.bra_name,d.dep_id,d.dep_name,"
					+ "s.s_user_id,s.s_user_name "
					+ "from users u,position p,faculty f,branch b,department d,s_user s "
					+ "where u.p_id = p.p_id and u.fac_id = f.fac_id and u.bra_name = b.bra_name and u.dep_id = d.dep_id and u.s_user_id = s.s_user_id "
					+ "order by user_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				users = new Users();
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
				list.add(users);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("usersview", list);
			
			response.setContentType("text/html");
			response.getWriter().print("usersview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
