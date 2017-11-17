package com.java.model;

public class Times {
	String time;
	
	public String DefaultTime(int st_time,int ed_time){
		for(int i=st_time;i<=ed_time;i++){
			if(i<9){
				time = "0"+i+":00";
			}else{
				time = i+":00";
			}
		}
		return this.time;
	}
	
	public String FormatTime(int time,int minute){
		if(time<10 && minute==0){
			this.time = "0"+time+":00";
		}else if(time<10 && minute>0){
			this.time = "0"+time+":"+minute;
		}else if(time>=10 && minute==0){
			this.time = time+":00";
		}else{
			this.time = time+":"+minute;
		}
		return this.time;
	}
}
