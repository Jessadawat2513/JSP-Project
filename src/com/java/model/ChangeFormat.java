package com.java.model;

public class ChangeFormat {
	String date_en , date_th;
	
	public String ChangeDateENtoTH(String date_en){
		System.out.println("Model : "+date_en);
		switch(date_en.substring(0,2)){
		case "01"  	:	date_th = date_en.substring(3,5)+"ม.ค."+date_en.substring(6);break;
		case "02"  	:	date_th = date_en.substring(3,5)+"ก.พ."+date_en.substring(6);break;
		case "03"  	:	date_th = date_en.substring(3,5)+"มี.ค."+date_en.substring(6);break;
		case "04"  	:	date_th = date_en.substring(3,5)+"เม.ย."+date_en.substring(6);break;
		case "05"  	:	date_th = date_en.substring(3,5)+"พ.ค."+date_en.substring(6);break;
		case "06"  	:	date_th = date_en.substring(3,5)+"มิ.ย."+date_en.substring(6);break;
		case "07"  	:	date_th = date_en.substring(3,5)+"ก.ค."+date_en.substring(6);break;
		case "08"  	:	date_th = date_en.substring(3,5)+"ส.ค."+date_en.substring(6);break;
		case "09" 	:	date_th = date_en.substring(3,5)+"ก.ย."+date_en.substring(6);break;
		case "10"	:	date_th = date_en.substring(3,5)+"ต.ค."+date_en.substring(6);break;
		case "11"	:	date_th = date_en.substring(3,5)+"พ.ย."+date_en.substring(6);break;
		case "12"	:	date_th = date_en.substring(3,5)+"ธ.ค."+date_en.substring(6);break;
		}
		return this.date_th;
	}
}
