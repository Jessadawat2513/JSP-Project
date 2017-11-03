package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class BranchEdit
 */
@WebServlet("/BranchEdit")
public class BranchEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchEdit() {
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
		String braname = request.getParameter("ids");
		
		Branch branch = new Branch();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select fac_id,bra_name,s_fbd_id from branch where bra_name = '"+braname+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				branch.setFacId(rs.getString("fac_id"));
				branch.setBranchName(rs.getString("bra_name"));
				branch.setStatusId(rs.getString("s_fbd_id"));
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("branchedit", branch);
			
			response.setContentType("text/html");
			response.getWriter().print("branchedit.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
