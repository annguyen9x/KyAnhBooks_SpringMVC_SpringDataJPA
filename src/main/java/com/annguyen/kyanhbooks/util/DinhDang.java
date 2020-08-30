package com.annguyen.kyanhbooks.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DinhDang {
	
	public static String MyNumberFormat(float numberInput, String pattern) {
		String tienString = "";
		NumberFormat numberFormat = new DecimalFormat(pattern);
		tienString = numberFormat.format(numberInput);
		return tienString;
	}
	
	public static Date MyDateFormat(String dateString, String pattern) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
}
