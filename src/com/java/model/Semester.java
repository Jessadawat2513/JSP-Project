package com.java.model;

public class Semester {
	String sem_id , sem_name ,year ,start_date ,end_date ,s_sem_id ,s_sem_name;
	
	public void setSemesterId(String sem_id){
		this.sem_id = sem_id;
	}
	
	public String getSemesterId(){
		return this.sem_id;
	}
	
	public void setSemesterName(String sem_name){
		this.sem_name = sem_name;
	}
	
	public String getSemesterName(){
		return this.sem_name;
	}
	
	public void setYear(String year){
		this.year = year;
	}
	
	public String getYear(){
		return this.year;
	}
	
	public void setStartdate(String start_date){
		this.start_date = start_date;
	}
	
	public String getStartdate(){
		return this.start_date;
	}
	
	public void setEnddate(String end_date){
		this.end_date = end_date;
	}
	
	public String getEnddate(){
		return this.end_date;
	}
	
	public void setStatusId(String s_sem_id){
		this.s_sem_id = s_sem_id;
	}
	
	public String getStatusId(){
		return this.s_sem_id;
	}
	
	public void setStatusName(String s_sem_name){
		this.s_sem_name = s_sem_name;
	}
	
	public String getStatusName(){
		return this.s_sem_name;
	}
}
