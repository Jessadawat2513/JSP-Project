package com.java.model;

public class G_booking {
	String bk_id,g_bk_no,rm_num;
	String firstname,lastname;
	String start_date,start_time;
	String end_date,end_time;
	String st_id,st_name;
	
	public void setBookingId(String bk_id){
		this.bk_id = bk_id;
	}
	
	public String getBookingId(){
		return this.bk_id;
	}
	
	public void setG_BookingNo(String g_bk_no){
		this.g_bk_no = g_bk_no;
	}
	
	public String getG_BookingNo(){
		return this.g_bk_no;
	}
	
	public void setRoomNum(String rm_num){
		this.rm_num = rm_num;
	}
	
	public String getRoomNum(){
		return this.rm_num;
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
	
	public void setStartDate(String start_date){
		this.start_date = start_date;
	}
	
	public String getStartDate(){
		return this.start_date;
	}
	
	public void setStartTime(String start_time){
		this.start_time = start_time;
	}
	
	public String getStartTime(){
		return this.start_time;
	}
	
	public void setEndDate(String end_date){
		this.end_date = end_date;
	}
	
	public String getEndDate(){
		return this.end_date;
	}
	
	public void setEndTime(String end_time){
		this.end_time = end_time;
	}
	
	public String getEndTime(){
		return this.end_time;
	}
	
	public void setStatusId(String st_id){
		this.st_id = st_id;
	}
	
	public String getStatusId(){
		return this.st_id;
	}
	
	public void setStatusName(String st_name){
		this.st_name = st_name;
	}
	
	public String getStatusName(){
		return this.st_name;
	}
}
