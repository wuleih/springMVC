package com.o2o.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConvertUtils {
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date){		
		return format(date,DATE_FORMAT);
	}
	
	public static String formatDateTime(Date date){		
		return format(date,DATE_TIME_FORMAT);
	}
	
	public static String format(Date date,String format){
		if (date == null)
			return null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	public static Date parse(String date,String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		if(date==null||date.trim()=="") return null;
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static long diffMinutes(Date t1,Date t2){
		long tms1 = t1.getTime();
		long tms2 = t2.getTime();
		return (tms2-tms1) / (1000 * 60);
	}
	
	/**
	 * 求开始截至日期之间的天数差.
	 * 
	 * @param d1
	 *            开始日期
	 * @param d2
	 *            截至日期
	 * @return 返回相差天数
	 */
	public static int getDaysInterval(Date d1, Date d2) {
		if (d1 == null || d2 == null)
			return 0;
		Date[] d = new Date[2];
		d[0] = d1;
		d[1] = d2;
		Calendar[] cal = new Calendar[2];
		for (int i = 0; i < cal.length; i++) {
			cal[i] = Calendar.getInstance();
			cal[i].setTime(d[i]);
			cal[i].set(Calendar.HOUR_OF_DAY, 0);
			cal[i].set(Calendar.MINUTE, 0);
			cal[i].set(Calendar.SECOND, 0);
		}
		long m = cal[0].getTime().getTime();
		long n = cal[1].getTime().getTime();
		int ret = (int) Math.abs((m - n) / 1000 / 3600 / 24);
		return ret;
	}
	
	/**
	 * 
	 * Description:指定日期加或减days天
	 * 
	 * @param date1日期
	 * @param days天数
	 * @return	 
	 * @since：2007-12-17 下午03:47:12
	 */
	public static Date addDay(Date date1, int days) {
		Calendar date = Calendar.getInstance();
		date.setTime(date1);
		date.add(Calendar.DAY_OF_YEAR, days);
		return date.getTime();
	}
}
