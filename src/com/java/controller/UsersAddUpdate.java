package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class UsersAddUpdate
 */
@WebServlet("/UsersAddUpdate")
public class UsersAddUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersAddUpdate() {
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
		String id = request.getParameter("fac_id");
		
		Branch branch;
		
		Map<String, String> options = new LinkedHashMap<>();
	    
	    Connection conn;
	    Statement st;
	    ResultSet rs;
	    
	    try{
	    	conn = ConnectionManager.getConnection();
	    	
	    	String qr = "select b.bra_name,b.s_fbd_id from faculty f,branch b where b.fac_id = f.fac_id and b.fac_id = '"+id+"' and b.s_fbd_id = '001'";
	    	
	    	st = conn.createStatement();
	    	rs = st.executeQuery(qr);
	    	
	    	while(rs.next()){
	    		branch = new Branch();
	    		branch.setBranchName(rs.getString("bra_name"));
	    		branch.setStatusId(rs.getString("s_fbd_id"));
	    		options.put(branch.getBranchName(), branch.getBranchName());
	    	}
	    	
	    	String json = new Gson().toJson(options);

		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    response.getWriter().close();
	    	
	    }catch(SQLException ex){
	    	
	    }
	}

}
