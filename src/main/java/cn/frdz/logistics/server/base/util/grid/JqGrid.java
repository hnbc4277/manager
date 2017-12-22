   package cn.frdz.logistics.server.base.util.grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import cn.frdz.logistics.server.base.util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 设置jqGrid请求和应答参数
 * 
 * @author sxc
 *
 */
public class JqGrid {
	
	//请求参数
	private int prm_page = 0; //表示请求页码的参数
	private int prm_rows = 0; //表示请求行数的参数
	private String filters = ""; //表示请求查询过滤条件参数
	
	private String sort = ""; //表示用于排序的列名的参数
	private String order = ""; //表示采用的排序方式的参数
	
	//查询数据库使用的参数
	private int start = 0; //开始记录数
	private int rows = 0; //每页行数
	
	private int subMainGridId = 0; //Grid请求带的一些其他参数
	private int subGridId = 0;
	private String args = "";
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getSubMainGridId() {
		return subMainGridId;
	}
	public void setSubMainGridId(int subMainGridId) {
		this.subMainGridId = subMainGridId;
	}
	public int getSubGridId() {
		return subGridId;
	}
	public void setSubGridId(int subGridId) {
		this.subGridId = subGridId;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	
	/**
	 * 设置jqGrid请求参数
	 * 
	 * @param model
	 * @return
	 */
	public String setParameter(ModelMap model) {
		prm_page = Util.objInt(model.get("prm_page"));
		prm_rows = Util.objInt(model.get("prm_rows"));
		sort = Util.objStr(model.get("prm_sort"));
		order = Util.objStr(model.get("prm_order"));
		subMainGridId = Util.objInt(model.get("subMainGridId"));
		subGridId = Util.objInt(model.get("subGridId"));
		args = Util.objStr(model.get("args"));
		
		//计算开始记录数
		start = (prm_page - 1) * prm_rows;
		rows = prm_rows;
		
		StringBuffer sql = new StringBuffer();
		//查询过滤条件
		this.filters = Util.objStr(model.get("filters"));
		if(!Util.strIsEmpty(this.filters)) {
			Filters filters = getFilters(this.filters);
			List<Rules> rulesList = getRulesList(filters.getRules());
			if(!Util.strIsEmpty(filters.getGroupOp())) {
				sql.append(getWhere(filters, rulesList));
			}
		}
		
		return sql.toString();
	}
	
	/**
	 * getWhere
	 * 
	 * @param filters
	 * @param rulesList
	 * @return
	 */
	private String getWhere(Filters filters, List<Rules> rulesList) {
		StringBuffer sqlWhere = new StringBuffer();
		String andOr = filters.getGroupOp();
		for(Rules rules: rulesList) {
			//组合查询条件
			if(rules.getField().toLowerCase().endsWith("time")) {//处理dataime数据查询条件
				sqlWhere.append(" ").append(andOr).append(" ").append(rules.getField()).append(" LIKE ")
				.append(" '").append(rules.getData()).append("%'");
			} else {
				sqlWhere.append(" ").append(andOr).append(" ").append(rules.getField()).append(" ").append(getOp(rules.getOp()));
				
				if(rules.getOp().toLowerCase().equals("cn") || rules.getOp().toLowerCase().equals("nc")) {
					sqlWhere.append(" '%").append(rules.getData()).append("%'");
				} else if(rules.getOp().toLowerCase().equals("in") || rules.getOp().toLowerCase().equals("ni")) {
					sqlWhere.append(" ('").append(rules.getData()).append("')");                 
				} else {
					sqlWhere.append(" '").append(rules.getData()).append("'");
				}
			}
			
		}
		return sqlWhere.toString();
	}
	
	/**
	 * getOp
	 * 
	 * @param op
	 * @return
	 */
	private String getOp(String op) {
		if(op.toLowerCase().equals("eq")) {
			return "=";
		} else if(op.toLowerCase().equals("ne")) {
			return "<>";
		} else if(op.toLowerCase().equals("lt")) {
			return "<";
		} else if(op.toLowerCase().equals("le")) {
			return "<=";
		} else if(op.toLowerCase().equals("gt")) {
			return ">";
		} else if(op.toLowerCase().equals("ge")) {
			return ">=";
		} else if(op.toLowerCase().equals("cn")) {
			return "like";
		} else if(op.toLowerCase().equals("nc")) {
			return "not like";
		} else if(op.toLowerCase().equals("in")) {
			return "in";
		} else if(op.toLowerCase().equals("ni")) {
			return "not in";
		} else if(op.toLowerCase().equals("bw")) {
			return "=";
		}
		return "";
	}
	
	/**
	 * getFilters
	 * 
	 * @param filters
	 * @return
	 */
	private Filters getFilters(String filters) {
		JSONArray ja = JSONArray.fromObject(new StringBuffer().append("[").append(filters).append("]").toString());
		JSONObject jo = ja.getJSONObject(0);
		
		Filters filter = new Filters();
		filter.setGroupOp(Util.objStr(jo.get("groupOp")));
		filter.setRules(Util.objStr(jo.get("rules")));
		
		return filter;
	}
	
	/**
	 * getRulesList
	 * 
	 * @param rules
	 * @return
	 */
	private List<Rules> getRulesList(String rules) {
		List<Rules> rulesList = new ArrayList<Rules>();
		JSONArray ja = JSONArray.fromObject(rules);
		
		for(int i = 0; i < ja.size(); i++) {
			JSONObject jo = ja.getJSONObject(i);
			Rules rule = (Rules)JSONObject.toBean(jo, Rules.class);
			rulesList.add(rule);
		}
		
		return rulesList;
	}
	
	/**
	 * 设置用户数据
	 * 
	 * @param pagingMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Map<String, Object> setUserData(Map pagingMap) {
		Footerrow footerrow = (Footerrow)pagingMap.get("footerrow");
		Map<String, Object> userData = new HashMap<String, Object>();
		//设置页尾数据行标题
		userData.put(footerrow.getTitleRow(), footerrow.getTitle());
		//设置页尾数据行
		Map<String, Object> row = footerrow.getRow();
		for(String key : row.keySet()) {
			userData.put(key, row.get(key));
		}
		return userData;
	}
	
	/**
	 * 设置jqGrid应答参数
	 *
	 * @param Map pagingMap
	 */
	public Map<String,Object> getParameter(Map<String,Object> pagingMap) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();	
		jsonMap.put("json_root", pagingMap.get("pagingList")); //表示实际模型数据的入口
		jsonMap.put("json_records", pagingMap.get("recordSize")); //表示数据行总数的参数
		jsonMap.put("json_page", prm_page); //表示当前页码的参数
		
		//计算页码总数
		int json_total = (int)Math.ceil(Util.objDouble(pagingMap.get("recordSize")) / Util.objDouble(rows));
		jsonMap.put("json_total", json_total);//表示页码总数的参数 
		
		//页尾数据行
		if(pagingMap.containsKey("footerrow") && pagingMap.get("footerrow") != null) {
			Map<String, Object> userdata = setUserData(pagingMap);
			userdata.put("newSql", pagingMap.get("newSql"));
			userdata.put("newArgs", pagingMap.get("newArgs"));
			jsonMap.put("userdata", userdata);
	    //用户数据	
		} else {
			Map<String, Object> userdata = new HashMap<String, Object>();
			userdata.put("newSql", pagingMap.get("newSql"));
			userdata.put("newArgs", pagingMap.get("newArgs"));
			jsonMap.put("userdata", userdata); 
		}
		
		return jsonMap;
	}
	
}
