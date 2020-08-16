package com.annguyen.kyanhbooks.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DinhDang {
	
	public static String MyNumberFormat(float numberInput, String pattern) {
		String tienString = "";
		NumberFormat numberFormat = new DecimalFormat(pattern);
		tienString = numberFormat.format(numberInput);
		return tienString;
	}
}
