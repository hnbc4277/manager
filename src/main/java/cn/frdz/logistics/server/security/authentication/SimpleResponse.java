package cn.frdz.logistics.server.security.authentication;
/**
 * 简单响应的封装类
 * 
 * @author sxc
 *
 */
public class SimpleResponse {
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
