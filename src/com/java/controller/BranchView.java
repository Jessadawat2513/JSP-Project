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
 * Servlet implementation class BranchView
 */
@WebServlet("/BranchView")
public class BranchView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchView() {
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
		String id = request.getParameter("ids");
		
		Faculty faculty = new Faculty();
		
		Branch branch;
		ArrayList<Branch> list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select b.bra_name,b.s_fbd_id from faculty f,branch b where b.fac_id = f.fac_id and b.fac_id = '"+id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				branch = new Branch();
				branch.setBranchName(rs.getString("bra_name"));
				branch.setStatusId(rs.getString("s_fbd_id"));
				list.add(branch);
			}
			
			String qr1 = "select fac_id,fac_name from faculty where fac_id = '"+id+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				faculty.setFacId(rs.getString("fac_id"));
				faculty.setFacName(rs.getString("fac_name"));
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("branchview", list);
			session.setAttribute("facultyname", faculty);
			
			response.setContentType("text/html");
			response.getWriter().print("branchview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
