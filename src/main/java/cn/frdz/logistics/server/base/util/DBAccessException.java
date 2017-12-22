package cn.frdz.logistics.server.base.util;

/**
 * 数据库访问异常类
 * 
 * @author sxc
 *
 */
@SuppressWarnings("serial")
public class DBAccessException extends RuntimeException {

	public DBAccessException() {
    	super();
    }
       
    public DBAccessException(String message) {
    	super(message);
    }
    
    public DBAccessException(String message, Throwable cause) {
        super(message, cause);
    }
        
    public DBAccessException(Throwable cause) {
        super(cause);
    }
    
}
