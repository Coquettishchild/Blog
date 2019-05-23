package com.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetThisTime {
	public static String Gettime() {
		Date data = new Date();
		SimpleDateFormat dataform = new SimpleDateFormat("yyyy-MM-dd");
		return dataform.format(data);
	}
}
