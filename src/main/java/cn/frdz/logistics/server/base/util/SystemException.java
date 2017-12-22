package cn.frdz.logistics.server.base.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 系统异常类
 * 
 * @author sxc
 *
 */
@SuppressWarnings("serial")
public class SystemException extends RuntimeException {

	public SystemException() {
		super();
	}
	
	public SystemException(String message) {
		super(message);
	}

	public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
        
    public SystemException(Throwable cause) {
        super(cause);
    }
    
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }

}
