package cn.frdz.logistics.server.base.util.grid;

/**
 * 查询过滤规则
 * 
 * @author sxc
 *
 */
public class Rules {
	
	private String field;
	private String op;
	private String data;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
