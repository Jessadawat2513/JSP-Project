package com.java.model;

public class Privilege {
	String privilegeid ,privilegename ,status;
	
	public void setPrivilegeId(String privilegeid){
		this.privilegeid = privilegeid;
	}
	
	public String getPrivilegeId(){
		return this.privilegeid;
	}
	
	public void setPrivilegeName(String privilegename){
		this.privilegename = privilegename;
	}
	
	public String getPrivilegeName(){
		return this.privilegename;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}
}
