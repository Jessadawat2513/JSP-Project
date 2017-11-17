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
 * Servlet implementation class UsersAdd
 */
@WebServlet("/UsersAdd")
public class UsersAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersAdd() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String pos_id = request.getParameter("pos_id");
		String fac_id = request.getParameter("fac_id");
		String bra_name = request.getParameter("bra_name");
		String dep_id = request.getParameter("dep_id");
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select to_char(sysdate,'DDMMYYYY') || lpad(nvl(substr(max(user_id),9,4),0)+1,4,'0') as nextid from users where to_char(sysdate,'DDMMYYYY') = substr(user_id,1,8)";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				st = conn.createStatement();
				
				String qr1 = "INSERT INTO "+"USERS"+" "
						+ "(USER_ID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,P_ID,FAC_ID,BRA_NAME,DEP_ID,S_USER_ID) "
						+ "VALUES ('"+rs.getString("nextid")+"','"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+pos_id+"','"+fac_id+"','"+bra_name+"','"+dep_id+"','001')";
				
				st.execute(qr1);
			}
			
			String qr1 = "UPDATE "+"POSITION"+" SET S_P_ID = '001' WHERE P_ID = '"+pos_id+"' AND S_P_ID = '002'";
			st = conn.createStatement();
			st.execute(qr1);
			
			String qr2 = "UPDATE "+"FACULTY"+" SET S_FBD_ID = '001' WHERE FAC_ID = '"+fac_id+"' AND S_FBD_ID = '002'";
			st = conn.createStatement();
			st.execute(qr2);
			
			String qr3 = "UPDATE "+"BRANCH"+" SET S_FBD_ID = '001' WHERE BRA_NAME = '"+bra_name+"' AND S_FBD_ID = '002'";
			st = conn.createStatement();
			st.execute(qr3);
			
			String qr4 = "UPDATE "+"DEPARTMENT"+" SET S_FBD_ID = '001' WHERE DEP_ID = '"+dep_id+"' AND S_FBD_ID = '002'";
			st = conn.createStatement();
			st.execute(qr4);
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("success");
			response.getWriter().close();
			
		}catch(SQLException ex){
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("fail");
			response.getWriter().close();
		}
	}

}
