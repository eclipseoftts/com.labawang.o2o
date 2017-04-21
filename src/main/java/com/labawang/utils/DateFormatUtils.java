package com.labawang.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {

	
	public static Date dateFormat(Date date){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		String format = dateFormat.format(date);
		Date dateTime = null;
		try {
			dateTime = dateFormat.parse(format);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateTime;
	}
}
