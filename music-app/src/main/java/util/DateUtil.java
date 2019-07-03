package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 用某种时间格式，格式化字符串
	 * @param date   日期 
	 * @param formatsr  格式
	 * @return
	 */
	public static String formate(Date date ,String formaStr){
	
		SimpleDateFormat sdf = new SimpleDateFormat(formaStr);
		String result = sdf.format(date);
		return result;
	}
	/**
	 * 按给定的格式把指定的字符串转化为时间
	 * @param formaStr 
	 * @param value 
	 * @return
	 */
	
	public static Date parseDate(String formaStr,String value){
		SimpleDateFormat sdf = new SimpleDateFormat(formaStr);
		Date date = null;
		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	

}
