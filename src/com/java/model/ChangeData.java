package com.java.model;

public class ChangeData {
	String day_id;
	
	public String ChangeDayToID(String day_name){
		switch(day_name){
		case "อาทิตย์ " 	:	day_id = "001";break;
		case "จันทร์  " 	:	day_id = "002";break;
		case "อังคาร  " 	:	day_id = "003";break;
		case "พุธ     " 	:	day_id = "004";break;
		case "พฤหัสบดี"	:	day_id = "005";break;
		case "ศุกร์   " 	:	day_id = "006";break;
		case "เสาร์   " 	:	day_id = "007";break;
		}
		return this.day_id;
	}
}
