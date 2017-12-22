package cn.frdz.logistics.server.base.repository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.frdz.logistics.server.base.util.DBAccessException;
import cn.frdz.logistics.server.base.util.Util;

/**
 * 操作数据库工具类
 * 
 * @author sxc
 *
 */
@Repository("jdbcRepository")
public class JdbcRepository implements IJdbcRepository {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public Map<String, Object> pagingMap(int start, int rows, String sql, Object[] args) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> pagingSql = pagingSql(start, rows, sql, args);

			String newSql = (String) pagingSql.get("newSql");
			Object[] newArgs = (Object[]) pagingSql.get("newArgs");

			List<Map<String, Object>> pagingList = executeQuery(newSql, newArgs);
			// 总记录数
			long recordSize = recordSize(sql, args);

			result.put("pagingList", pagingList);
			result.put("recordSize", recordSize);
			result.put("newSql", newSql);
			result.put("newArgs", newArgs);
		} catch (Exception e) {
			result.put("pagingList", new ArrayList<Map<String, Object>>(0));
			result.put("recordSize", new Long(0));
		}
		return result;
	}

	public <T> Map<String, Object> pagingMapper(int start, int rows, String sql, Object[] args,
			RowMapper<T> rowMapper) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> pagingSql = pagingSql(start, rows, sql, args);

			String newSql = (String) pagingSql.get("newSql");
			Object[] newArgs = (Object[]) pagingSql.get("newArgs");

			List<T> pagingList = executeQuery(newSql, newArgs, rowMapper);
			// 总记录数
			long recordSize = recordSize(sql, args);

			result.put("pagingList", pagingList);
			result.put("recordSize", recordSize);
			result.put("newSql", newSql);
			result.put("newArgs", newArgs);
		} catch (Exception e) {
			result.put("pagingList", new ArrayList<Map<String, Object>>(0));
			result.put("recordSize", new Long(0));
		}
		return result;
	}
	
	public List<Map<String, Object>> executeQuery(String sql, Object[] args) {
		List<Map<String, Object>> result = null;
		try {
			result = jdbcTemplate.queryForList(sql, args);
		} catch (Exception e) {
			result = new ArrayList<Map<String, Object>>();
			throw new DBAccessException(e);
		}
		return result;
	}

	public <T> List<T> executeQuery(String sql, Object[] args, RowMapper<T> rowMapper) {
		List<T> result = null;
		try {
			result = jdbcTemplate.query(sql, args, rowMapper);
		} catch (Exception e) {
			result = new ArrayList<T>();
			throw new DBAccessException(e);
		}
		return result;
	}
	
	public Map<String, Object> queryForMap(String sql, Object[] args) {
		Map<String, Object> result = null;
		try {
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, args);
			if(list != null && list.size() > 0){
				result = list.get(0);
			}
//			result = jdbcTemplateTypeJudge(jdbcTemplateType).queryForList(sql, args);//查不到数据会抛异常 没找到解决办法
		} catch (Exception e) {
			System.out.println(e);
			throw new DBAccessException(e);
		}
		return result;
	}
	
	public <T> T queryMapper(String sql, Object[] args, RowMapper<T> rowMapper) {
		T result = null;
		try {
			List<T> list = jdbcTemplate.query(sql, args, rowMapper);
			if(list != null && list.size() > 0){
				result = list.get(0);
			}
//			result = jdbcTemplateTypeJudge(jdbcTemplateType).queryForObject(sql, args, rowMapper);//查不到数据会抛异常 没找到解决办法
		} catch (Exception e) {
			throw new DBAccessException(e);
		}
		return result;
	}
	
	public <T> int save(T columnT) {
		try {
			StringBuffer sql = new StringBuffer();
			StringBuffer column = new StringBuffer();
			StringBuffer val = new StringBuffer();
			if(columnT != null) {
				Class<? extends Object> clazz = columnT.getClass();
				System.out.println(camel2Underline(clazz.getSimpleName()));
				Field[] fields = clazz.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) { 
					String fieldName = fields[i].getName();
					column.append(camel2Underline(fieldName)).append(", ");
					val.append(getFieldValueByName(fieldName,columnT,fields[i].getType().getSimpleName())).append(", ");
				}
				String columnStr = column.toString().substring(0, column.toString().lastIndexOf(", "));
				String valStr = val.toString().substring(0, val.toString().lastIndexOf(", "));
				sql.append("INSERT INTO ").append(camel2Underline(clazz.getSimpleName())).append(" (")
										.append(columnStr).append(")").append(" VALUES (").append(valStr).append(")");
			}
			return jdbcTemplate.update(sql.toString());
			
		} catch(Exception e) {
			throw new DBAccessException(e);
		}
	}
	
	public int update(String sql) {
		try {
			return jdbcTemplate.update(sql);
		} catch(Exception e) {
			throw new DBAccessException(e);
		}
	}
	
	public int delete(String sql) {
		try {
			return jdbcTemplate.update(sql);
		} catch(Exception e) {
			throw new DBAccessException(e);
		}
	}

	private String camel2Underline(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }
	
	private <T> Object getFieldValueByName(String fieldName, Object o,String fieldType) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			if("String".equals(fieldType)){
				value = "'"+ value +"'";
			}
			return value;
		} catch (Exception e) {
			throw new DBAccessException(e);
		}
	}
	
	
	private Map<String, Object> pagingSql(int start, int rows, String sql, Object[] args) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			int end = start + rows;
			String newSql = pagingSql(sql);
			int len = 0;
			if (args == null || args.length <= 0) {
				len = 0;
			} else {
				len = args.length;
			}
			// 生成新的参数列表,原有的参数列表以及后增加的两个开始记录和结束记录数的参数
			Object newArgs[] = new Object[end > 0 ? (len + 2) : (len + 1)];
			for (int i = 0; i < len; i++) {
				newArgs[i] = args[i];
			}
			if (end > 0) {
				newArgs[len] = start;
				newArgs[len + 1] = end;
			} else {
				newArgs[len] = start;
			}
			result.put("newSql", newSql);
			result.put("newArgs", newArgs);

			return result;
		} catch (Exception e) {
			throw new DBAccessException(e);
		}
	}

	private long recordSize(String sql, Object[] args) {
		try {
			Map<String, Object> map = null;
			map = jdbcTemplate.queryForMap(sizeSql(sql), args);
			if (map != null) {
				return Util.objLong(map.get("num"));
			}
		} catch (Exception e) {
			throw new DBAccessException(e);
		}
		return 0;
	}

	private String sizeSql(String sql) {
		if (sql.toUpperCase().indexOf("UNION") != -1 || sql.toUpperCase().indexOf("GROUP BY") != -1
				|| sql.toUpperCase().indexOf("CASE") != -1) {
			return new StringBuffer().append("SELECT COUNT(1)  AS num FROM (").append(sql).append(")").toString();
		}
		sql = sql.trim();
		int selectPos = sql.toUpperCase().indexOf("SELECT");
		int fromPos = sql.toUpperCase().indexOf("FROM");
		if (selectPos == -1 || fromPos == -1) {
			throw new DBAccessException("无效的SQL语句,未发现SELECT,FROM关键字");
		}
		String sizeSql = sql.substring(0, selectPos + 6) + " COUNT(1) AS num " + sql.substring(fromPos, sql.length());

		return sizeSql;
	}

	private String pagingSql(String sql) {
		return String.format(" SELECT a.* FROM (%s) a LIMIT ?,? ", sql);
	}

}
