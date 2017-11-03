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
 * Servlet implementation class PrivilegeView
 */
@WebServlet("/PrivilegeView")
public class PrivilegeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrivilegeView() {
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
		Privilege privilege;
		ArrayList<Privilege> pri_list = new ArrayList<>();
		
		Position position;
		ArrayList<Position> pos_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select pri_id,pri_name from privilege order by pri_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				privilege = new Privilege();
				privilege.setPrivilegeId(rs.getString("pri_id"));
				privilege.setPrivilegeName(rs.getString("pri_name"));
				pri_list.add(privilege);
			}
			
			String qr1 = "select p_id,p_name,s_p_id from position order by p_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				position = new Position();
				position.setPid(rs.getString("p_id"));
				position.setPname(rs.getString("p_name"));
				position.setStatusId(rs.getString("s_p_id"));
				pos_list.add(position);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("positionview", pos_list);
			session.setAttribute("privilegeview", pri_list);
			
			response.setContentType("text/html");
			response.getWriter().print("privilegeview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
