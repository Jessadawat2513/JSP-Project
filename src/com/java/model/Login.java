package com.java.model;

public class Login {
	String user_id,username ,firstname ,lastname ,pid ,pname ,status;
	boolean valid = false;
	
	public void setUserId(String user_id){
		this.user_id = user_id;
	}
	
	public String getUserId(){
		return this.user_id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public String getLastname(){
		return this.lastname;
	}
	
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
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public void setValid(Boolean valid){
		this.valid = valid;
	}
	
	public Boolean getValid(){
		return this.valid;
	}
}
