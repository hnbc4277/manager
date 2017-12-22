package cn.frdz.logistics.server.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统工具类
 * 
 * @author sxc
 *
 */
public class Util {

	/**
	 * 判断一个字符串是否为空字符串,当String == null 或 String.equals("")都为空
	 * 
	 * 注:当字符串中包含空格时,也不是空字符串,即方法不会截断字符串中的空格
	 * 
	 * @param str
	 *            待判断的字符串
	 * @return boolean true:传入的字符串为空,false:字符串不为空
	 */
	public static boolean strIsEmpty(CharSequence str) {
		return (str == null) || (str.toString().trim().equals(""));
	}

	/**
	 * 字符串转换成布尔型
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean strBoolean(CharSequence str) {
		try {
			return Boolean.parseBoolean(str.toString());
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 字符串转换成整型
	 * 
	 * @param str
	 * @return Integer
	 */
	public static int strInt(CharSequence str) {
		try {
			return Integer.parseInt(str.toString());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 字符串转换成长整型
	 * 
	 * @param str
	 * @return long
	 */
	public static long strLong(CharSequence str) {
		try {
			return Long.parseLong(str.toString());
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 字符串转换成浮点型
	 * 
	 * @param str
	 * @return float
	 */
	public static float strFloat(CharSequence str) {
		try {
			return Float.parseFloat(str.toString());
		} catch (Exception e) {
			return 0F;
		}
	}

	/**
	 * 字符串转换成双精度型
	 * 
	 * @param str
	 * @return double
	 */
	public static double strDouble(CharSequence str) {
		try {
			return Double.parseDouble(str.toString());
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 布尔型转换成字符串
	 * 
	 * @param val
	 * @return String
	 */
	public static String booleanStr(boolean val) {
		try {
			return String.valueOf(val);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 整型转换成字符串
	 * 
	 * @param val
	 * @return String
	 */
	public static String intStr(int val) {
		try {
			return String.valueOf(val);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 长整型转换成字符串
	 * 
	 * @param val
	 * @return String
	 */
	public static String longStr(long val) {
		try {
			return String.valueOf(val);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 浮点型转换成字符串
	 * 
	 * @param val
	 * @return String
	 */
	public static String floatStr(float val) {
		try {
			return String.valueOf(val);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 双精度型转换成字符串
	 * 
	 * @param val
	 * @return String
	 */
	public static String doubleStr(double val) {
		try {
			return String.valueOf(val);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 对象转换成布尔型
	 * 
	 * @param obj
	 * @return boolean
	 */
	public static boolean objBoolean(Object obj) {
		try {
			if (obj == null) {
				return false;
			}
			return Boolean.parseBoolean(obj.toString());
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 对象转换成整型
	 * 
	 * @param obj
	 * @return Integer
	 */
	public static int objInt(Object obj) {
		try {
			if (obj == null) {
				return 0;
			}
			return Integer.parseInt(obj.toString());
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 对象转换成长整型
	 * 
	 * @param obj
	 * @return long
	 */
	public static long objLong(Object obj) {
		try {
			if (obj == null) {
				return 0L;
			}
			return Long.parseLong(obj.toString());
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 对象转换成浮点型
	 * 
	 * @param obj
	 * @return float
	 */
	public static float objFloat(Object obj) {
		try {
			if (obj == null) {
				return 0F;
			}
			return Float.parseFloat(obj.toString());
		} catch (Exception e) {
			return 0F;
		}
	}

	/**
	 * 对象转换成双精度型
	 * 
	 * @param obj
	 * @return double
	 */
	public static double objDouble(Object obj) {
		try {
			if (obj == null) {
				return 0D;
			}
			return Double.parseDouble(obj.toString());
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 对象转换成字符串
	 * 
	 * @param obj
	 * @return String
	 */
	public static String objStr(Object obj) {
		try {
			if (obj == null) {
				return "";
			}
			return obj.toString();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 对象转换成日期
	 * 
	 * @param obj
	 * @return Date
	 */
	public static Date objDate(Object obj) {
		try {
			if (obj == null) {
				return new Date();
			}
			return (Date) obj;
		} catch (Exception e) {
			return new Date();
		}
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param obj
	 * @return Date
	 */
	public static Date strDate(String format, String dtrDate) {
		try {
			if ("".equals(dtrDate)) {
				return new Date();
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(dtrDate);
		} catch (Exception e) {
			return new Date();
		}
	}

	/**
	 * 根据日期计算年龄
	 * 
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static int getAge(Date birthDay) throws Exception {
		try {
			Calendar cal = Calendar.getInstance();
			int yearNow = cal.get(Calendar.YEAR);
			int monthNow = cal.get(Calendar.MONTH);
			int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
			cal.setTime(birthDay);
			int yearBirth = cal.get(Calendar.YEAR);
			int monthBirth = cal.get(Calendar.MONTH);
			int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
			int age = yearNow - yearBirth;
			if (monthNow <= monthBirth) {
				if (monthNow == monthBirth) {
					if (dayOfMonthNow < dayOfMonthBirth)
						age--;
				} else {
					age--;
				}
			}
			return age;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 错误或异常对象转换成字符串
	 * 
	 * @param e
	 *            错误或异常对象
	 * @return String
	 */
	public static String throwableStr(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

	/**
	 * 对字符串进行HTML格式编码 转换： 回车 => <br/>
	 * 空格 => &nbsp; < => &lt; > => &gt;
	 * 
	 * @param str
	 *            普通格式的字符串
	 * @return String
	 */
	public static String htmlCoding(String str) {
		String html = str.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r\n", "<br>").replaceAll(" ",
				"&nbsp;");
		return html;
	}

	/**
	 * 对HTML格式的字符串解码
	 * 
	 * 转换： <br/>
	 * => 回车 &nbsp; => 空格 &lt; => < &gt; => >
	 * 
	 * @param html
	 *            HTML格式的字符串
	 * @return String
	 */
	public static String htmlDecode(String html) {
		String str = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("<br>", "\r\n")
				.replaceAll("&nbsp;", " ");
		return str;
	}

	/**
	 * 保证指定的值在转换成字符串后,具有指定的长度,如果不足指定的长度,前面将补"0"
	 * 
	 * @param val
	 *            原始字符串值
	 * @param len
	 *            最终的字符串长度
	 * @return String
	 */
	public static String padStrZero(int val, int len) {
		String result = intStr(val);
		return padStrZero(result, len);
	}

	/**
	 * 保证指定的值在转换成字符串后,具有指定的长度,如果不足指定的长度,前面将补"0"
	 * 
	 * @param val
	 *            原始字符串值
	 * @param len
	 *            最终的字符串长度
	 * @return String
	 */
	public static String padStrZero(long val, int len) {
		String result = longStr(val);
		return padStrZero(result, len);
	}

	/**
	 * 保证指定的值在转换成字符串后,具有指定的长度,如果不足指定的长度,前面将补"0"
	 * 
	 * @param val
	 *            原始字符串值
	 * @param len
	 *            最终的字符串长度
	 * @return String
	 */
	public static String padStrZero(String val, int len) {
		String result = val;
		while (result.length() < len) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * 带格式解码,编码转换
	 * 
	 * @param str
	 *            要解码的的字符串
	 * @param srcEncoding
	 *            原始字符串的编码
	 * @param destEncoding
	 *            目标字符串的编码
	 * @return
	 */
	public static String encoding(String str, String srcEncoding, String destEncoding) {
		try {
			byte[] src = URLDecoder.decode(str, destEncoding).getBytes(srcEncoding);
			String dest = new String(src, destEncoding);
			return dest;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 不带格式解码,编码转换
	 * 
	 * @param str
	 *            要解码的字符串
	 * @param srcEncoding
	 *            原始字符串的编码
	 * @param destEncoding
	 *            目标字符串的编码
	 * @return
	 */
	public static String encodingNoDecode(String str, String srcEncoding, String destEncoding) {
		try {
			byte[] src = str.getBytes(srcEncoding);
			String dest = new String(src, destEncoding);
			return dest;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 四舍五入
	 * 
	 * @param val
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return String 四舍五入后的结果
	 */
	public static String round(double val, int scale) {
		if (scale < 0) {
			throw new SystemException("无效的scale参数,参数scale必须是大于或等于零的整数");
		} else {
			// 下面的舍入模式是ROUND_HALF_UP
			BigDecimal bd = new BigDecimal(Double.toString(val));
			return objStr(bd.setScale(scale, BigDecimal.ROUND_HALF_UP));
		}
	}

	/**
	 * double类型输出格式处理
	 * 
	 * @param val
	 *            需要输出格式处理的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return String 输出格式处理后的结果
	 */
	public static String doubleFormat(double val, int scale) {
		if (scale < 0) {
			throw new SystemException("无效的scale参数,参数scale必须是大于或等于零的整数");
		} else {
			String valStr = doubleStr(val);
			String num = valStr.substring(0, valStr.indexOf("."));
			String dec = valStr.substring(valStr.indexOf(".") + 1, valStr.length());
			// 下面处理输出格式
			String format = "";
			if (dec.length() > scale) {
				dec = dec.substring(0, scale);
			} else {
				while (dec.length() < scale) {
					dec = dec + "0";
				}
			}
			// 是否带小数点处理
			if (scale > 0) {
				format = num + "." + dec;
			} else {
				format = num;
			}
			return format;
		}
	}

	/**
	 * 从HttpServletRequest获取全部参数,以Map形式返回
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @return Map
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> getParameterValues(HttpServletRequest request) {
		Map<String, String> parameter = new HashMap<String, String>();
		Enumeration enume = request.getParameterNames();
		while (enume.hasMoreElements()) {
			String key = objStr(enume.nextElement());
			String value = request.getParameter(key).trim();
			parameter.put(key, value);
		}
		return parameter;
	}

	/**
	 * 从HttpServletRequest获取全部参数,以Map形式返回
	 * 
	 * @param request
	 *            HttpServletRequest对象
	 * @param srcEncoding
	 *            原始字符串的编码
	 * @param destEncoding
	 *            目标字符串的编码
	 * @return Map
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> getParameterValues(HttpServletRequest request, String srcEncoding,
			String destEncoding) {
		Map<String, String> parameter = new HashMap<String, String>();
		Enumeration enume = request.getParameterNames();
		while (enume.hasMoreElements()) {
			String key = objStr(enume.nextElement());
			String value = encoding(request.getParameter(key).trim(), srcEncoding, destEncoding);
			parameter.put(key, value);
		}
		return parameter;
	}

	/**
	 * 生成n位随机数
	 * 
	 * @param n
	 *            位数
	 * @return
	 */
	public static String randomNumber(int n) {
		String randomStr = "";
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] rands = new char[n];
		for (int i = 0; i < rands.length; i++) {
			int rand = (int) (Math.random() * str.length());
			rands[i] = str.charAt(rand);
		}
		for (int i = 0; i < rands.length; i++) {
			randomStr += rands[i];
		}
		return randomStr;
	}

	/**
	 * 自动生成32位的UUid，对应数据库的主键id进行插入用。
	 * 
	 * @return
	 */
	public static String getUUID() {

		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 获取外网IP
	 * 
	 * @return
	 */
	public static String getV4IP() {
		String ip = "";
		String chinaz = "http://ip.chinaz.com";

		StringBuilder inputLine = new StringBuilder();
		String read = "";
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedReader in = null;
		try {
			url = new URL(chinaz);
			urlConnection = (HttpURLConnection) url.openConnection();
			in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			while ((read = in.readLine()) != null) {
				inputLine.append(read + "\r\n");
			}
		} catch (Exception e) {
			new SystemException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					new SystemException(e);
				}
			}
		}
		Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
		Matcher m = p.matcher(inputLine.toString());
		if (m.find()) {
			String ipstr = m.group(1);
			ip = ipstr;
		}
		return ip;
	}

}
