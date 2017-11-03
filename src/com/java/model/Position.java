package com.java.model;

public class Position {
	String pid , pname, s_pid ,s_pname;
	
	public void setPid(String pid){
		this.pid = pid;
	}
	
	public String getPid(){
		return this.pid;
	}
	
	public void setPname(String pname){
		this.pname = pname;
	}
	
	public String getPname(){
		return this.pname;
	}
	
	public void setStatusId(String s_pid){
		this.s_pid = s_pid;
	}
	
	public String getStatusId(){
		return this.s_pid;
	}
	
	public void setStatusName(String s_pname){
		this.s_pname = s_pname;
	}
	
	public String getStatusName(){
		return this.s_pname;
	}
}
