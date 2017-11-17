package com.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class ScheduleAdd
 */
@WebServlet("/ScheduleAdd")
public class ScheduleAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAdd() {
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
		String semester = request.getParameter("semester");
		String room = request.getParameter("room");
		String course = request.getParameter("course");
		String day = request.getParameter("day");
		String classes = request.getParameter("classes");
		String[] t_style = request.getParameterValues("ck_list[]");
		String nextid,sem_id,year;
		String response_txt = null;
		
		boolean check = false;
		
		Map<String, String> status = new LinkedHashMap<>();

		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		
		System.out.println(semester);
		System.out.println(semester.substring(0,2));
		System.out.println(semester.substring(3));
		System.out.println(room);
		System.out.println(course);
		System.out.println(day);
		System.out.println(classes);
		for(String data: t_style){
			System.out.println("Teach : "+data);
		}
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr_ck = "select count(*) as count from schedule where sem_id = '"+semester.substring(0,3)+"' and year = '"+semester.substring(3)+"' and day_id = '"+day+"' and class_id = '"+classes+"' and bk_id in (select bk_id from t_booking where rm_num = '"+room+"')";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr_ck);
			
			while(rs.next()){
				System.out.println(rs.getString("count"));
				if(Integer.parseInt(rs.getString("count")) > 0){
					System.out.println("Have Data !!!");
					check = false;
				}else{
					System.out.println("No Have Data !!!");
					check = true;
				}
			}
			
			if(check){
			if(!(semester.equals("") || room.equals("") || course.equals("") || day.equals("") || classes.equals(""))){
				System.out.println(semester.substring(0,3));
				System.out.println(semester.substring(3));
				String qr = "select to_char(sysdate,'DDMMYYYY') || lpad(nvl(substr(max(bk_id),9,4),'0')+1,4,'0') as nextid from booking where to_char(sysdate,'DDMMYYYY') = substr(bk_id,1,8)";
				
				st = conn.createStatement();
				rs = st.executeQuery(qr);
				while(rs.next()){
					System.out.println("Query qr !!!");
					nextid = rs.getString("nextid");
					System.out.println(rs.getString("nextid"));
					System.out.println(nextid);
					String qr1 = "INSERT INTO "+"BOOKING"+" (BK_ID,USER_ID,BK_DATE,BK_TIME) VALUES ('"+rs.getString("nextid")+"','"+login.getUserId()+"',(select to_char(sysdate,'YYYY-MM-DD') from dual),(select to_char(sysdate,'HH:MI') from dual))";
					st = conn.createStatement();
					st.execute(qr1);
					System.out.println("Query qr1 !!!");
					
					for(String data : t_style){
						String qr2 = "select nvl(max(t_bk_no),'0')+1 as t_bk_no from t_booking where bk_id = '"+nextid+"'";
						st = conn.createStatement();
						rs = st.executeQuery(qr2);
						while(rs.next()){
							System.out.println("Query qr2 !!!");
							String qr3 = "INSERT INTO "+"T_BOOKING"+" (BK_ID,T_BK_NO,RM_NUM) VALUES ('"+nextid+"','"+rs.getString("t_bk_no")+"','"+room+"')";
							st = conn.createStatement();
							st.execute(qr3);
							System.out.println("Query qr3 !!!");
							System.out.println(nextid+":"+rs.getString("t_bk_no")+":"+course+":"+semester+":"+day+":"+classes+":"+data);
							String qr4 = "INSERT INTO "+"SCHEDULE"+" (BK_ID,T_BK_NO,C_CODE,SEM_ID,YEAR,DAY_ID,CLASS_ID,TEACHID)"
									+ " VALUES ('"+nextid+"','"+rs.getString("t_bk_no")+"','"+course+"','"+semester.substring(0,3)+"','"+semester.substring(3)+"','"+day+"','"+classes+"','"+data+"')";
							st = conn.createStatement();
							st.execute(qr4);
							System.out.println("Query qr4 !!!");
						}
					}
				}
				response_txt = "success";
			}else{
				System.out.println("Have null");
				response_txt = "fail";
			}
			}else{
				response_txt = "more";
			}
			
			response.setContentType("text/plain");
			response.getWriter().write(response_txt);
			response.getWriter().close();
			
		}catch(SQLException ex){
			
		}
	}

}
