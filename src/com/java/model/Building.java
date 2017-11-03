package com.java.model;

public class Building {
	String b_id ,b_name, b_position ,note ,s_b_id ,s_b_name;
	
	public void setBuildId(String b_id){
		this.b_id = b_id;
	}
	
	public String getBuildId(){
		return this.b_id;
	}
	
	public void setBuildName(String b_name){
		this.b_name = b_name;
	}
	
	public String getBuildName(){
		return this.b_name;
	}
	
	public void setBuildPosition(String b_position){
		this.b_position = b_position;
	}
	
	public String getBuildPosition(){
		return this.b_position;
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
	public String getNote(){
		return this.note;
	}
	
	public void setStatusId(String s_b_id){
		this.s_b_id = s_b_id;
	}
	
	public String getStatusId(){
		return this.s_b_id;
	}
	
	public void setStatusName(String s_b_name){
		this.s_b_name = s_b_name;
	}
	
	public String getStatusName(){
		return this.s_b_name;
	}
}
