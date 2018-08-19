package com.demo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DemoUtils {
	
	public static String genMemberCode(Date today , String phone) {	

		DateFormat df = new SimpleDateFormat("YYYYMMdd");
		today = Calendar.getInstance().getTime(); 
		String strDate = df.format(today);
		return String.format("%s%s", strDate, phone.substring(phone.length() - 4));

	}

	

	public static String genMemberType(int salary) {		

		String type = "";		

		if(salary > 50000) {
			type = "Platinum" ;
		}else if(salary < 30000) {
			type = "Gold" ;
		}else {
			type = "Silver" ; 
		}		
		return type;

	}

}
