package com.java.model;

public class Department {
	String dep_id ,dep_name,s_fbd_id ,s_fbd_name;
	
	public void setDepId(String dep_id){
		this.dep_id = dep_id;
	}
	
	public String getDepId(){
		return this.dep_id;
	}
	
	public void setDepName(String dep_name){
		this.dep_name = dep_name;
	}
	
	public String getDepName(){
		return this.dep_name;
	}
	
	public void setStatusId(String s_fbd_id){
		this.s_fbd_id = s_fbd_id;
	}
	
	public String getStatusId(){
		return this.s_fbd_id;
	}
	
	public void setStatusName(String s_fbd_name){
		this.s_fbd_name = s_fbd_name;
	}
	
	public String getStatusName(){
		return this.s_fbd_name;
	}
}
