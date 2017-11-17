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
 * Servlet implementation class UsersDelete
 */
@WebServlet("/UsersDelete")
public class UsersDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDelete() {
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
		String user_id = request.getParameter("user_id");
		String position = null;
		String faculty = null;
		String branch = null;
		String department = null;
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select p_id,fac_id,bra_name,dep_id from users where user_id = '"+user_id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				position = rs.getString("p_id");
				faculty = rs.getString("fac_id");
				branch = rs.getString("bra_name");
				department = rs.getString("dep_id");
			}
			
			String qr1 = "DELETE FROM "+"USERS"+" WHERE USER_ID = '"+user_id+"'";
			
			st = conn.createStatement();
			st.executeQuery(qr1);
			
			String qr2 = "select count(user_id) as count from users where p_id = '"+position+"'";
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			while(rs.next()){
				if(rs.getString("count").equals("0")){
					String qr0 = "UPDATE "+"POSITION"+" SET S_P_ID = '002' WHERE P_ID = '"+position+"' AND S_P_ID = '001'";
					st = conn.createStatement();
					st.execute(qr0);
				}
			}
			
			String qr3 = "select count(fac_id) as count from users where fac_id = '"+faculty+"'";
			st = conn.createStatement();
			rs = st.executeQuery(qr3);
			while(rs.next()){
				if(rs.getString("count").equals("0")){
					String qr0 = "UPDATE "+"FACULTY"+" SET S_FBD_ID = '002' WHERE FAC_ID = '"+faculty+"' AND S_FBD_ID = '001'";
					st = conn.createStatement();
					st.execute(qr0);
				}
			}
			
			String qr4 = "select count(bra_name) as count from users where bra_name = '"+branch+"'";
			st = conn.createStatement();
			rs = st.executeQuery(qr4);
			while(rs.next()){
				if(rs.getString("count").equals("0")){
					String qr0 = "UPDATE "+"BRANCH"+" SET S_FBD_ID = '002' WHERE BRA_NAME = '"+branch+"' AND S_FBD_ID = '001'";
					st = conn.createStatement();
					st.execute(qr0);
				}
			}
			
			String qr5 = "select count(dep_id) as count from users where dep_id = '"+department+"'";
			st = conn.createStatement();
			rs = st.executeQuery(qr5);
			while(rs.next()){
				if(rs.getString("count").equals("0")){
					String qr0 = "UPDATE "+"DEPARTMENT"+" SET S_FBD_ID = '002' WHERE DEP_ID = '"+department+"' AND S_FBD_ID = '001'";
					st = conn.createStatement();
					st.execute(qr0);
				}
			}
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("success");
			response.getWriter().close();
			
		}catch(SQLException ex){
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("fail");
			response.getWriter().close();
		}
	}

}
