package com.refresh.pos.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *處理日期格式

 */
public class DateTimeStrategy {
	
	private static Locale locale;
	private static SimpleDateFormat dateFormat;
	
	private DateTimeStrategy() {
		// Static class
	}
	
	/**
	 * 設置時間

	 */
	public static void setLocale(String lang, String reg) {
		locale = new Locale(lang, reg);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", locale);
	}
	
	/**
	 * 設置TIME形式

	 */
	public static String format(String date) {
		return dateFormat.format(Calendar.getInstance(locale).getTime());
	}
	
	/**
	 *

	 */
	public static String getCurrentTime() {
		return dateFormat.format(Calendar.getInstance().getTime()).toString();
	}
	
	/**
	 * 轉換形式給SQL
	 */
	public static String getSQLDateFormat(Calendar instance) {
		return dateFormat.format(instance.getTime()).toString().substring(0,10);
	}

}
