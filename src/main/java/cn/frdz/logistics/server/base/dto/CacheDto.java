package cn.frdz.logistics.server.base.dto;
/**
 * 缓存dto
 * @author BIEE
 *
 */
public class CacheDto {
	
	private String url;
	
	private int port;
	
	private int timeOut;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	

}
