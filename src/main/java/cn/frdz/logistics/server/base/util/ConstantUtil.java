package cn.frdz.logistics.server.base.util;

/**
 * 系统常量类
 * 
 * @author sxc
 *
 */
public class ConstantUtil {

	/**
	 * HttpSession中的属性名称,用于绑定用户信息
	 */	
	public static final String SESSION_USER = "SessionUser";
	
	public static final String SESSION_USER_ID = "SessionUserId";
	/**
	 * 状态-成功
	 */
	public static final int STATUS_SUCCESS = 1;
	/**
	 * 状态-失败
	 */
	public static final int STATUS_FAIL = 0;
	/**
	 * 系统管理员
	 */
	public static final int SYS_ADMIN = 1;
	
	public static final int UN_SYS_ADMIN = 0;
	
	
	
	/************************************************************************************
	 * JdbcTemplate
	 ************************************************************************************/
	/**
	 * 第一个数据源
	 */
	public static final String PRIMARY_JDBC_TEMPLATE = "primaryJdbcTemplate";
	/**
	 * 第二个数据源
	 */
	public static final String SECONDARY_JDBC_TEMPLATE = "secondaryJdbcTemplate";
	
	/************************************************************************************
	 * mysql
	 ************************************************************************************/
	/**
	 * mysql-日期格式
	 */
	public static final String MYSQL_DATE_FORMAT = "'%Y-%m-%d %H:%i:%s'";
	/**
	 * mysql-时间格式
	 */
	public static final String MYSQL_DATE_FORMAT_TIME = "'%H:%i:%s'";
	/**
	 * java-日期格式
	 */
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * java-日期格式
	 */
	public static final String DATE_FORMAT_YMD = "yyMMdd";
	
	
	/************************************************************************************
	 * Bad data
	 ************************************************************************************/
	/**
	 * 业务流水号
	 */
	public static final String BAD_DATA_BFNUM = "'00000000000000000000000000000000','FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF'";	
	/**
	 * 桩编号
	 */
	public static final String BAD_DATA_DEVID="'0000000000000000'";
	
	/************************************************************************************
	 * 设备状态（16进制）
	 ************************************************************************************/
	/**
	 * 空闲
	 */
	public static final String DEVSTATUS_FREE = "20";
	/**
	 * 故障
	 */
	public static final String DEVSTATUS_FAULT0 = "10";
	public static final String DEVSTATUS_FAULT1 = "30";
	public static final String DEVSTATUS_FAULT2 = "40";
	public static final String DEVSTATUS_FAULT3 = "60";
	/**
	 * 充电
	 */
	public static final String DEVSTATUS_CHARGE0 = "50";
	public static final String DEVSTATUS_CHARGE1 = "91";
	/**
	 * 停车
	 */
	public static final String DEVSTATUS_PARKING = "70";
	/**
	 * 预约
	 */
	public static final String DEVSTATUS_MAKE_APPOINTMENT = "80";
	/**
	 * 非法占用
	 */
	public static final String DEVSTATUS_ILLEGAL_OCCUPATION = "90";
	/**
	 * 空闲
	 */
	public static final String FREE = "free";
	/**
	 * 故障
	 */
	public static final String FAULT = "fault";
	/**
	 * 充电
	 */
	public static final String CHARGE = "charge";
	/**
	 * 停车
	 */
	public static final String PARKING = "parking";
	/**
	 * 预约
	 */
	public static final String MAKE_APPOINTMENT = "makeAppointment";
	/**
	 * 非法占用
	 */
	public static final String ILLEGAL_OCCUPATION = "illegalOccupation";
}
