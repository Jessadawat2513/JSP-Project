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
 * Servlet implementation class ApproveView
 */
@WebServlet("/ApproveView")
public class ApproveView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveView() {
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
		Queue queue;
		ArrayList<Queue> queue_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();

			String qr = "select q.bk_id,q.g_bk_no,q.rm_num,q.q_no,u.firstname,u.lastname,g.start_date,g.start_time,g.end_date,g.end_time from queue q,booking b,users u,g_booking g where u.user_id = b.user_id and q.bk_id = b.bk_id and g.bk_id = b.bk_id order by substr(q.bk_id,9,4),q.q_no asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				queue = new Queue();
				queue.setBookingId(rs.getString("bk_id"));
				queue.setG_BookingNo(rs.getString("g_bk_no"));
				queue.setRoomNum(rs.getString("rm_num"));
				queue.setQueueNo(rs.getString("q_no"));
				queue.setFirstname(rs.getString("firstname"));
				queue.setLastname(rs.getString("lastname"));
				queue.setStartdate(rs.getString("start_date"));
				queue.setEnddate(rs.getString("end_date"));
				queue.setStarttime(rs.getString("start_time"));
				queue.setEndtime(rs.getString("end_time"));
				queue_list.add(queue);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("queue_list", queue_list);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("approveview.jsp");
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
