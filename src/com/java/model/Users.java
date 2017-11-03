package com.java.model;

public class Users {
	String id,username,password,firstname,lastname;
	String pid,pname;
	String facid,facname;
	String braname;
	String depid,depname;
	String sid,sname;
	
	public void setUserId(String id){
		this.id = id;
	}
	
	public String getUserId(){
		return this.id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
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
	
	public void setPosId(String pid){
		this.pid = pid;
	}
	
	public String getPosId(){
		return this.pid;
	}
	
	public void setPosName(String pname){
		this.pname = pname;
	}
	
	public String getPosName(){
		return this.pname;
	}
	
	public void setFacId(String facid){
		this.facid = facid;
	}
	
	public String getFacId(){
		return this.facid;
		
	}
	
	public void setFacName(String facname){
		this.facname = facname;
	}
	
	public String getFacName(){
		return this.facname;
	}
	
	public void setBraName(String braname){
		this.braname = braname;
	}
	
	public String getBraName(){
		return this.braname;
	}
	
	public void setDepId(String depid){
		this.depid = depid;
	}
	
	public String getDepId(){
		return this.depid;
	}
	
	public void setDepName(String depname){
		this.depname = depname;
	}
	
	public String getDepName(){
		return this.depname;
	}
	
	public void setStatusId(String sid){
		this.sid = sid;
	}
	
	public String getStatus(){
		return this.sid;
	}
	
	public void setStatusName(String sname){
		this.sname = sname;
	}
	
	public String getStatusName(){
		return this.sname;
	}
}
