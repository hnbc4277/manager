package cn.frdz.logistics.server.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期、时间工具类
 * 
 * @author sxc
 *
 */
public class DateUtil {
	
	/**
	 * 格式化日期
	 * 
	 * @param date  要格式化的日期
	 * @param format 格式化形式
	 * @return 格式化的日期字符串
	 */
	public static String dateFormatString(Date date, String format) {
		if(date == null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 获取当前服务器时间的年份
	 * @return 年份
	 */
	public static String getYear() {
		return dateFormatString(new Date(), "yyyy");
	}

	/**
	 * 获取当前服务器时间的月份
	 * @return 月份
	 */
	public static String getMonth() {
		return dateFormatString(new Date(), "MM");
	}

	/**
	 * 获取当前服务器时间的日期
	 * @return 日期
	 */
	public static String getDay() {
		return dateFormatString(new Date(), "dd");
	}
	
	/**
	 * 获取当前服务器时间的小时
	 * @return 小时
	 */
	public static String getHour() {
		return dateFormatString(new Date(), "kk");
	}

	/**
	 * 获取当前服务器时间的分
	 * @return 分
	 */
	public static String getMinute() {
		return dateFormatString(new Date(), "mm");
	}

	/**
	 * 获取当前服务器时间的秒
	 * @return 秒
	 */ 
	public static String getSecond() {
		return dateFormatString(new Date(), "ss");
	}

	/**
	 * 获取当前服务器时间的年-月-日
	 * @return 年-月-日
	 */
	public static String getDate() {
		return dateFormatString(new Date(), "yyyy-MM-dd");
	}
	
	/**
	 * 获取当前服务器时间的年月日
	 * @return 年月日
	 */
	public static String getToDate() {
		return dateFormatString(new Date(), "yyyyMMdd");
	}

	/**
	 * 获取当前服务器时间的时:分:秒
	 * @return 时:分:秒
	 */
	public static String getTime() {
		return dateFormatString(new Date(), "kk:mm:ss");
	}
	
	/**
	 * 获取当前服务器时间的年-月-日 时:分:秒
	 * @return 年-月-日 时:分:秒
	 */
	public static String getDateTime() {
		return dateFormatString(new Date(), "yyyy-MM-dd kk:mm:ss");
	}
	
	/**
	 * 获取当前服务器时间戳
	 * @return 时间戳字符串
	 */
	public static String getTimeToStr() {
		return Util.longStr(new Date().getTime());
	}
	
	/**
	 * 获取当前年份整型值
	 * @return 整型值
	 */
	public static int getIntYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);		
	}
	
	/**
	 * 获取当前月份整型值
	 * @return 整型值
	 */
	public static int getIntMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 获取当前星期几
	 * @return 字符串
	 */
	public static String getDayOfWeek() {
	    Calendar calendar = Calendar.getInstance();    
	    int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	    switch (day_of_week) {
			case 0: {
				return "星期日";
			}
		    case 1: {
				return "星期一";
			}
			case 2: {
				return "星期二";
			}
			case 3: {
				return "星期三";
			}
			case 4: {
				return "星期四";
			}
			case 5: {
				return "星期五";
			}
			case 6: {
				return "星期六";
			}
			case 7: {
				return "星期日";
			}
			default:
				return "";
		} 
	}
	
	/**
	 * 日期比较
	 * 
	 * @param startDate
	 * @param endDate
	 * @return -1：小于、0：相等、1：大于
	 */
	public static int dateCompareTo(String startDate, String endDate) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			
			start.setTime(formatter.parse(startDate));
			end.setTime(formatter.parse(endDate));
			
			return start.compareTo(end);
		} catch(Exception e) { 
			throw new SystemException(e.getMessage()); 
		} 
	}
	
	/**
	 * 获取日期差,返回相差天数
	 * 
	 * @param startDate 
	 * @param endDate
	 * @return 相差天数
	 */
	public static long getDateDifference(String startDate, String endDate) { 	
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	     	Date start = formatter.parse(startDate);    
	     	Date end = formatter.parse(endDate);
	     	
	     	long diff  = end.getTime() - start.getTime();
	     	long days  = diff / (24 * 60 * 60 * 1000);
	     	
	     	return days ;
		} catch(Exception e) { 
			throw new SystemException(e.getMessage()); 
		} 
	}
	
    /** 
     * 获得指定日期的前N天 
     *  
     * @param specifiedDay 
     * @return 
     * @throws Exception 
     */  
    public static Date getSpecifiedNDayBefore(Date date, int n) {//可以用new Date().toLocalString()传递参数  
    	try {
    		Calendar c = Calendar.getInstance();  
	        c.setTime(date);  
	        int day = c.get(Calendar.DATE);  
	        c.set(Calendar.DATE, day - n);  
	  
	        return c.getTime();  
    	}catch (Exception e) {
    		throw new SystemException(e.getMessage()); 
		}
    }  
    
    public static List<String> intervalDate(String startDate, String endDate,String affFormat,String outFormat){
    	List<String> dateList = new ArrayList<String>();
    	try {
			if (dateCompareTo(startDate, endDate) <= 0) {
				SimpleDateFormat affSdf = new SimpleDateFormat(affFormat);
				SimpleDateFormat outSdf = new SimpleDateFormat(outFormat);
				Date d1 = affSdf.parse(startDate);
				Date d2 = affSdf.parse(endDate);
				Calendar c = Calendar.getInstance();
				c.setTime(d1);
				dateList.add(outSdf.format(c.getTime()));
				while (!c.getTime().equals(d2)){
					c.add(Calendar.DATE, 1);// 日期加1
					dateList.add(outSdf.format(c.getTime()));
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return dateList;
    }
	
}
