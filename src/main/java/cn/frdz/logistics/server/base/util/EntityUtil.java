package cn.frdz.logistics.server.base.util;

import javax.persistence.Table;

/**
 * 实体工具类
 * 
 * @author sxc
 *
 */
public class EntityUtil {

	/**
	 * 通过实体对象获取表名
	 * 
	 * @param obj
	 * @return
	 */
	public static String getTableName(Object obj){
		try {
			return obj.getClass().getAnnotation(Table.class).name();
		} catch (Exception e) {
			new SystemException(e);
		}
		return "";
	}
	
	/**
	 * 获取实体主键值
	 * 
	 * @param obj
	 * @return
	 */
	public static String getIdValue(Object obj){
		try {
//			for(java.lang.reflect.Field f:User.class.getDeclaredFields()){
//				if(f.isAnnotationPresent(Id.class)) {  
//					f.setAccessible(true);
//					return (String)f.get(obj);
//	            }
//			}
		} catch (Exception e) {
			new SystemException(e);
		}
		return "";
	}
}
