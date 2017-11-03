package com.java.model;

public class Coursedetail {
	String c_code , c_name;
	String sem_id , sem_name , year;
	
	public void setC_code(String c_code){
		this.c_code = c_code;
	}
	
	public String getC_code(){
		return this.c_code;
	}
	
	public void setC_name(String c_name){
		this.c_name = c_name;
	}
	
	public String getC_name(){
		return this.c_name;
	}
	
	public void setSemId(String sem_id){
		this.sem_id = sem_id;
	}
	
	public String getSemId(){
		return this.sem_id;
	}
	
	public void setSemName(String sem_name){
		this.sem_name = sem_name;
	}
	
	public String getSemName(){
		return this.sem_name;
	}
	
	public void setYear(String year){
		this.year = year;
	}
	
	public String getYear(){
		return this.year;
	}
}
