package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.java.controller.*;
import com.java.model.*;
/**
 * Servlet implementation class ApproveManagement
 */
@WebServlet("/ApproveManagement")
public class ApproveManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveManagement() {
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
		String action = request.getParameter("action");
		String bk_id = request.getParameter("bk_id");
		String g_bk_no = request.getParameter("g_bk_no");
		String rm_num = request.getParameter("rm_num");
		String queue_no = request.getParameter("queue_no");

		Connection conn;
		Statement st;
		ResultSet  rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			switch(action){
			case "Approve" :
				String qr = "UPDATE "+"G_BOOKING"+" SET S_BK_ID = '004' WHERE BK_ID = '"+bk_id+"' AND G_BK_NO = '"+g_bk_no+"'";
				st = conn.createStatement();
				st.executeQuery(qr);
				String qr1 = "UPDATE "+"G_BOOKING"+" SET S_BK_ID = '005' WHERE RM_NUM = (SELECT RM_NUM FROM QUEUE WHERE BK_ID = '"+bk_id+"') and S_BK_ID = '002'";
				st = conn.createStatement();
				st.execute(qr1);
				String qr2 = "DELETE FROM "+"QUEUE"+" WHERE RM_NUM = '"+rm_num+"'";
				st = conn.createStatement();
				st.execute(qr2);
				break;
			case "NonApprove" :
				int i = 1;
				i = i + Integer.parseInt(queue_no);
				String qr3 = "DELETE FROM "+"QUEUE"+" WHERE BK_ID = '"+bk_id+"' and G_BK_NO = '"+g_bk_no+"' and RM_NUM = '"+rm_num+"' and Q_NO = '"+queue_no+"'";
				st = conn.createStatement();
				st.execute(qr3);
				String qr4 = "UPDATE "+"G_BOOKING"+" SET S_BK_ID = '005' WHERE BK_ID = '"+bk_id+"' AND G_BK_NO = '"+g_bk_no+"'";
				st = conn.createStatement();
				st.execute(qr4);
				break;
			case "Cancel" :
				String qr5 = "DELETE FROM "+"QUEUE"+" WHERE BK_ID = '"+bk_id+"' and G_BK_NO = '"+g_bk_no+"'";
				st = conn.createStatement();
				st.execute(qr5);
				String qr6 = "UPDATE "+"G_BOOKING"+" SET S_BK_ID = '005' WHERE BK_ID = '"+bk_id+"' AND G_BK_NO = '"+g_bk_no+"'";
				st = conn.createStatement();
				st.execute(qr6);
				break;
			}
			
		}catch(SQLException ex){
			
		}
	}

}
