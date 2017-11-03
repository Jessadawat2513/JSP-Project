package com.java.model;

public class Classtime {
	String day_id,day_name;
	String class_id,class_name;
	String st_time,ed_time;
	String s_id,s_name;
	
	public void setDayId(String day_id){
		this.day_id = day_id;
	}
	
	public String getDayId(){
		return this.day_id;
	}
	
	public void setDayName(String day_name){
		this.day_name = day_name;
	}
	
	public String getDayName(){
		return this.day_name;
	}
	
	public void setClassId(String class_id){
		this.class_id = class_id;
	}
	
	public String getClassId(){
		return this.class_id;
	}
	
	public void setClassName(String class_name){
		this.class_name = class_name;
	}
	
	public String getClassName(){
		return this.class_name;
	}
	
	public void setStartTime(String st_time){
		this.st_time = st_time;
	}
	
	public String getStartTime(){
		return this.st_time;
	}
	
	public void setEndTime(String ed_time){
		this.ed_time = ed_time;
	}
	
	public String getEndTime(){
		return this.ed_time;
	}
	
	public void setStatusId(String s_id){
		this.s_id = s_id;
	}
	
	public String getStatusId(){
		return this.s_id;
	}
	
	public void setStatusName(String s_name){
		this.s_name = s_name;
	}
	
	public String getStatusName(){
		return this.s_name;
	}
}
