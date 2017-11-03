package com.java.model;

public class Room {
	String rm_num ,line ,lps , seat, cat_id, cat_name, b_id, b_name, s_rm_id, s_rm_name;
	
	public void setRoomNum(String rm_num){
		this.rm_num = rm_num;
	}
	
	public String getRoomNum(){
		return this.rm_num;
	}
	
	public void setLine(String line){
		this.line = line;
	}
	
	public String getLine(){
		return this.line;
	}
	
	public void setLPS(String lps){
		this.lps = lps;
	}
	
	public String getLPS(){
		return this.lps;
	}
	
	public void setSeat(String seat){
		this.seat = seat;
	}
	
	public String getSeat(){
		return this.seat;
	}
	
	public void setCatId(String cat_id){
		this.cat_id = cat_id;
	}
	
	public String getCatId(){
		return this.cat_id;
	}
	
	public void setCatName(String cat_name){
		this.cat_name = cat_name;
	}
	
	public String getCatName(){
		return this.cat_name;
	}
	
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
	
	public void setStatusRoomId(String s_rm_id){
		this.s_rm_id = s_rm_id;
	}
	
	public String getStatusRoomId(){
		return this.s_rm_id;
	}
	
	public void setStatusRoomName(String s_rm_name){
		this.s_rm_name = s_rm_name;
	}
	
	public String getStatusRoomName(){
		return this.s_rm_name;
	}
}
