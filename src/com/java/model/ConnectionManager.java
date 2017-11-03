package com.java.model;

import java.sql.*;

public class ConnectionManager {
	static Connection conn;
	static String Driver = "oracle.jdbc.driver.OracleDriver";
	static String ConnectURL = "jdbc:oracle:thin:@localhost:1521:FIRSTDB";
	static String Username = "Project";
	static String Password = "project12345";
	
	public static Connection getConnection(){
		try{
			Class.forName(Driver);
			try{
				conn = DriverManager.getConnection(ConnectURL,Username,Password);
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
		return conn;
	}
}
