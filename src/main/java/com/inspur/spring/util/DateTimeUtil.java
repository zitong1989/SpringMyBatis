package com.inspur.spring.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String getCurrentTime() {
		return sdf.format(new Date());
	}
}
