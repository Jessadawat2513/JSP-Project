package com.java.model;

public class Category {
	String cat_id ,cat_name ,s_cat_id ,s_cat_name;
	
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
	
	public void setStatusId(String s_cat_id){
		this.s_cat_id = s_cat_id;
	}
	
	public String getStatusId(){
		return this.s_cat_id;
	}
	
	public void setStatusName(String s_cat_name){
		this.s_cat_name = s_cat_name;
	}
	
	public String getStatusName(){
		return this.s_cat_name;
	}
}
