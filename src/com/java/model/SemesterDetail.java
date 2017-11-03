package com.java.model;

public class SemesterDetail {
	String sem_id ,sem_name;
	
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
}
