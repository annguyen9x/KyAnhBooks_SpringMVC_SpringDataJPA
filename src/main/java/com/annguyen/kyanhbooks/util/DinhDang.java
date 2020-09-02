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
	
	public static Date MyNewDateFormat(Date inputDate, String inputPattern, String outputPattern) {
		Date outputDate = null;
		String outputDateString = "";
		SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
		SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
		try {
			outputDateString = inputFormat.format(inputDate);
			outputDate = outputFormat.parse(outputDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return outputDate;
	}
	
	public static String MyStringDateFormat(Date date, String pattern) {
		String dateStr = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		dateStr = dateFormat.format(date);
		
		return dateStr;
	}
}
