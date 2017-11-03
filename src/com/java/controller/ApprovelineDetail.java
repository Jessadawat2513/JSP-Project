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
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.java.controller.*;
import com.java.model.*;

/**
 * Servlet implementation class ApprovelineDetail
 */
@WebServlet("/ApprovelineDetail")
public class ApprovelineDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovelineDetail() {
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
		String category = request.getParameter("ids");
		String ap_value = request.getParameter("ap_value");
		
		Map<String, String> data = new LinkedHashMap<>();
		
		Category category_name = new Category();
		
		Approvedetail approvedetail;
		ArrayList<Approvedetail> ap_list = new ArrayList<>();
		
		Position position;
		ArrayList<Position> pos_list = new ArrayList<>();
		
		int i = 1;
		
		Connection conn;
		Statement st;
		ResultSet rs;
		
		try{
			conn = ConnectionManager.getConnection();
			
			switch(action){
			case "Ap_line_No_Add" :
				String qr = "select lpad(nvl(max(d_ap_id),0)+1,3,'0') as nextid from d_approve";
				st = conn.createStatement();
				rs = st.executeQuery(qr);
				while(rs.next()){
					String qr1 = "INSERT INTO "+"D_APPROVE"+" (D_AP_ID,CAT_ID) VALUES ('"+rs.getString("nextid")+"','"+category+"')";
					st = conn.createStatement();
					st.execute(qr1);
				}
				break;
			case "Ap_line_No_Delete" :
				String qr2 = " DELETE FROM "+"D_APPROVE"+" WHERE D_AP_ID = '"+ap_value+"'";
				st = conn.createStatement();
				st.execute(qr2);
				break;
			}
			
			String qr = "select cat_id,cat_name from category where cat_id = '"+category+"'";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr);
			
			while(rs.next()){
				category_name.setCatId(rs.getString("cat_id"));
				category_name.setCatName(rs.getString("cat_name"));
			}
			
			String qr1 = "select d_ap_id from d_approve where cat_id = '"+category+"' order by d_ap_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr1);
			
			while(rs.next()){
				approvedetail = new Approvedetail();
				approvedetail.setApdId(rs.getString("d_ap_id"));
				approvedetail.setApdName("สายที่ "+i);
				approvedetail.setCatId(category);
				ap_list.add(approvedetail);
				data.put(approvedetail.getApdId(), approvedetail.getApdName());
				i++;
			}
			
			String qr2 = "select p_id,p_name from position where s_p_id = '001' order by p_id asc";
			
			st = conn.createStatement();
			rs = st.executeQuery(qr2);
			
			while(rs.next()){
				position = new Position();
				position.setPid(rs.getString("p_id"));
				position.setPname(rs.getString("p_name"));
				pos_list.add(position);
			}
			
			String json = new Gson().toJson(data);
			
			HttpSession session = request.getSession();
			session.setAttribute("category_name", category_name);
			session.setAttribute("ap_list", ap_list);
			session.setAttribute("position_list", pos_list);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			response.getWriter().close();
			
		}catch(SQLException ex){
		}
	}

}
