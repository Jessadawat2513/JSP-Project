package com.java.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class PositionAdd
 */
@WebServlet("/PositionAdd")
public class PositionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PositionAdd() {
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
		String positionname = request.getParameter("posname");
		
		Position position = new Position();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select lpad(nvl(max(p_id),0)+1,3,'0') as nextid from position";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				position.setPid(rs.getString("nextid"));
				st = conn.createStatement();
				
				String qr1 = "INSERT INTO "+"POSITION"+" (P_ID ,P_NAME,S_P_ID) VALUES ('"+rs.getString("nextid")+"','"+positionname+"','001')";
				
				st.execute(qr1);
			}
			
			String qr2 = "select pri_id from privilege order by pri_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				String qr3 = "INSERT INTO "+"M_PRIVILEGE"+" (P_ID,PRI_ID,S_PRI_ID) VALUES ('"+position.getPid()+"','"+rs.getString("pri_id")+"','002')";
				
				st = conn.createStatement();
				st.execute(qr3);
			}
			
			response.setContentType("text/plain");
			response.getWriter().print("success");
			response.getWriter().close();
			
		}catch(SQLException ex){
			response.setContentType("text/plain");
			response.getWriter().print("fail");
			response.getWriter().close();
		}
	}

}
