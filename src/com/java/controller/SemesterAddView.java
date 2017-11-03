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
 * Servlet implementation class SemesterAddView
 */
@WebServlet("/SemesterAddView")
public class SemesterAddView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterAddView() {
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
		SemesterDetail  d_sem;
		ArrayList<SemesterDetail> d_sem_list = new ArrayList<>();
		
		Year year = new Year();
		Year year1;
		ArrayList<Year> year_list = new ArrayList<>();
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			String qr = "select sem_id,sem_name from d_semester order by sem_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				d_sem = new SemesterDetail();
				d_sem.setSemesterId(rs.getString("sem_id"));
				d_sem.setSemesterName(rs.getString("sem_name"));
				d_sem_list.add(d_sem);
			}
			
			String qr1 = "select to_char(sysdate,'YYYY') as year from dual";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				year.setYear(rs.getString("year"));
				for(int i = Integer.parseInt(year.getYear())-10;i<=Integer.parseInt(year.getYear())+20;i++){
					year1 = new Year();
					year1.setYear(Integer.toString(i));
					year_list.add(year1);
				}
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("d_sem_list", d_sem_list);
			session.setAttribute("year_list", year_list);
			session.setAttribute("year", year);
			
		}catch(SQLException ex){
			
		}
	}

}
