package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.*;
import com.java.controller.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Login login = new Login();
		
		Privilege privilege;
		ArrayList<Privilege> list = new ArrayList<>();
		
		Connection conn;
		Statement st,st1;
		ResultSet rs,rs1;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select user_id,username ,password ,firstname ,lastname ,p_id ,s_user_id from users where username = '"+username+"' and password = '"+password+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			while(rs.next()){
				login.setUserId(rs.getString("user_id"));
				login.setUsername(rs.getString("username"));
				login.setFirstname(rs.getString("firstname"));
				login.setLastname(rs.getString("lastname"));
				login.setPid(rs.getString("p_id"));
				login.setStatus(rs.getString("s_user_id"));
				login.setValid(true);
				
				String qr1 = "select pr.pri_name ,p.pri_id ,p.s_pri_id from m_privilege p ,privilege pr where pr.pri_id = p.pri_id and p.p_id = '"+rs.getString("p_id")+"' order by pri_id asc";
				
				st1 = conn.createStatement();
				rs1 = st1.executeQuery(qr1);
				
				while(rs1.next()){
					privilege = new Privilege();
					privilege.setPrivilegeId(rs1.getString("pri_id"));
					privilege.setPrivilegeName(rs1.getString("pri_name"));
					privilege.setStatus(rs1.getString("s_pri_id"));
					list.add(privilege);
				}
			}
			
			HttpSession session = request.getSession(true);
			
			if(login.getValid()){
				session.setAttribute("login", login);
				session.setAttribute("privilege", list);
			}
			
			response.setContentType("text/html");
			response.getWriter().print(login.getValid());
			response.getWriter().close();
		}catch(SQLException ex){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
