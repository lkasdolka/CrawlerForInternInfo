package cn.edu.bupt.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getDate(){
		Calendar cal = Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);   
		int m=cal.get(Calendar.MONTH) + 1;   
		int d=cal.get(Calendar.DATE);   
		int h=cal.get(Calendar.HOUR_OF_DAY);   
		int mi=cal.get(Calendar.MINUTE);   
		int s=cal.get(Calendar.SECOND);   
		return y+"-"+m+"-"+d+" "+h+"::"+mi+"::"+s;
	}
}
