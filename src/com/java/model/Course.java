package com.java.model;

public class Course {
	String c_code ,c_name ,credit ,s_c_id ,s_c_name;
	
	public void setCourseCode(String c_code){
		this.c_code = c_code;
	}
	
	public String getCourseCode(){
		return this.c_code;
	}
	
	public void setCourseName(String c_name){
		this.c_name = c_name;
	}
	
	public String getCourseName(){
		return this.c_name;
	}
	
	public void setCredit(String credit){
		this.credit = credit;
	}
	
	public String getCredit(){
		return this.credit;
	}
	
	public void setStatusId(String s_c_id){
		this.s_c_id = s_c_id;
	}
	
	public String getStatusId(){
		return this.s_c_id;
	}
	
	public void setStatusName(String s_c_name){
		this.s_c_name = s_c_name;
	}
	
	public String getStatusName(){
		return this.s_c_name;
	}
}
