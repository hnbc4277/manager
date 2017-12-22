package cn.frdz.logistics.server.base.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

/**
 * 操作数据库工具类
 * 
 * @author sxc
 *
 */
public interface IJdbcRepository {

	/**
	 * 查询单条数据（Mapper）
	 * 
	 * @param sql 查询语句
	 * @param args 查询条件（没有为null）
	 * @return 返回查询结果（有数据为map，没数据返回null）
	 */
	public Map<String, Object> queryForMap(String sql, Object[] args);
	
	
	/**
	 * 查询单条数据（Mapper）
	 * 
	 * @param sql 查询语句
	 * @param args 查询条件（没有为null）
	 * @param rowMapper 结果集泛型
	 * @return （有数据为结果集泛型rowMapper，没数据返回null）
	 */
	public <T> T queryMapper(String sql, Object[] args, RowMapper<T> rowMapper);
	
	/**
	 * 查询（Map）
	 * 
	 * @param sql 查询语句
	 * @param args 查询条件（没有为null）
	 * @return 结果集
	 */
	public List<Map<String, Object>> executeQuery(String sql, Object[] args);
	
	/**
	 * 查询（Mapper）
	 * 
	 * @param sql 查询语句
	 * @param args 查询条件（没有为null）
	 * @param rowMapper 结果集泛型
	 * @return 结果集
	 */
	public <T> List<T> executeQuery(String sql, Object[] args, RowMapper<T> rowMapper);
	
	/**
	 * 分页查询（Map）
	 * 
	 * @param start 起始记录数
	 * @param rows 显示条数
	 * @param sql 查询语句
	 * @param args 查询条件（没有为null）
	 * @return 分页数据（Map）
	 */
	public Map<String, Object> pagingMap(int start, int rows, String sql, Object[] args);

	/**
	 * 分页查询（Mapper）
	 * 
	 * @param start 起始记录数
	 * @param rows 显示条数
	 * @param sql 查询语句
	 * @param args 查询条件（没有为null）
	 * @param rowMapper 结果集泛型
	 * @return 分页数据（Mapper）
	 */
	public <T> Map<String, Object> pagingMapper(int start, int rows, String sql, Object[] args,
			RowMapper<T> rowMapper);
	
	/**
	 * 保存数据
	 * @param <T>
	 * 
	 * @param tableName 数据库表名
	 * @param columnMap 查询条件=>columnMap
	 *                         key：对应表的字段名
	 *                         value：对应字段值
	 * @return 执行结果 =>
	 *                大于0：执行成功
	 *                小于等于：执行失败
	 */
	
	/**
	 * 保存方法
	 * 
	 * @param columnT 要保存的对象
	 * 
	 * @return 执行结果 =>
	 *                大于0：执行成功
	 *                小于等于：执行失败
	 */
	public <T> int save(T columnT);
	
	/**
	 * 更新方法
	 * 
	 * @param sql update更新语句
	 * @return
	 */
	public int update(String sql);
	
	/**
	 * 删除方法
	 * 
	 * @param sql delete更新语句
	 * @return
	 */
	public int delete(String sql);
}
