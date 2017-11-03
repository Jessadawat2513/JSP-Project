package com.java.model;

public class Queue {
	String bk_id,g_bk_no,rm_num,q_no;
	String firstname,lastname;
	String startdate,enddate;
	String starttime,endtime;
	String s_bk_id,s_bk_name;
	
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
	
	public void setStartdate(String startdate){
		this.startdate = startdate;
	}
	
	public String getStartdate(){
		return this.startdate;
	}
	
	public void setEnddate(String enddate){
		this.enddate = enddate;
	}
	
	public String getEnddate(){
		return this.enddate;
	}
	
	public void setStarttime(String starttime){
		this.starttime = starttime;
	}
	
	public String getStarttime(){
		return this.starttime;
	}
	
	public void setEndtime(String endtime){
		this.endtime = endtime;
	}
	
	public String getEndtime(){
		return this.endtime;
	}
	
	public void setQueueNo(String q_no){
		this.q_no = q_no;
	}
	
	public String getQueueNo(){
		return this.q_no;
	}
	
	public void setStatusId(String s_bk_id){
		this.s_bk_id = s_bk_id;
	}
	
	public String getStatusId(){
		return this.s_bk_id;
	}
	
	public void setStatusName(String s_bk_name){
		this.s_bk_name = s_bk_name;
	}
	
	public String getStatusName(){
		return this.s_bk_name;
	}
}
