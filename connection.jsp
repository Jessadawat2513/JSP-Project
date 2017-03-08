<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>
<%
		Connection connect = null;
		Statement s = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:First","First","5711850028");
			if(connect!=null){
				out.println("Database Connect.");
			}else{
				out.println("Database Disconnect.");
			}
		}catch(Exception e){
			out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try{
			connect.close();
		}catch(SQLException e){
			out.println(e.getMessage());
			e.printStackTrace();
		}
	%>
</body>
</html>