package cn.frdz.logistics.server.base.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.frdz.logistics.server.base.repository.IJdbcRepository;

/**
 * 系统中基础的业务类,为其他业务类提供基础方法
 * 
 * @author sxc
 *
 */
@Service
public abstract class BaseService implements IBaseService {
	
	@Autowired
	protected IJdbcRepository jdbcRepository;
	
	/**
	 * Log4j对象,可在派生类中直接使用
	 */
	protected Logger log = Logger.getLogger(this.getClass());
	
}
