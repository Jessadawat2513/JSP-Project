package com.java.model;

public class Branch {
	String fac_id,bra_name,s_fbd_id ,s_fbd_name;
	
	public void setFacId(String fac_id){
		this.fac_id = fac_id;
	}
	
	public String getFacId(){
		return this.fac_id;
	}
	
	public void setBranchName(String bra_name){
		this.bra_name = bra_name;
	}
	
	public String getBranchName(){
		return this.bra_name;
	}
	
	public void setStatusId(String s_fbd_id){
		this.s_fbd_id = s_fbd_id;
	}
	
	public String getStatusId(){
		return this.s_fbd_id;
	}
	
	public void setStatusName(String s_fbd_name){
		this.s_fbd_name = s_fbd_name;
	}
	
	public String getStatusName(){
		return this.s_fbd_name;
	}
}
