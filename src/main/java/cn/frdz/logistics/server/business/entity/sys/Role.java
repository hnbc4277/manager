package cn.frdz.logistics.server.business.entity.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色
 * 
 * @author sxc
 *
 */
@Entity
@Table(name = "sys_user")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "rid", columnDefinition = "varchar(64) COMMENT '手机号码'")
	private String rid;

	@Column(name = "rolename", columnDefinition = "varchar(64) COMMENT '角色名称'")
	private String rolename;

	@Column(name = "rtypeole", columnDefinition = "varchar(32) default '' COMMENT '角色类型'")
	private String rtypeole;

	@Column(name = "createtime", columnDefinition = "varchar(16) COMMENT '创建时间'")
	private String createtime;

	@Column(name = "createuser", columnDefinition = "varchar(16) COMMENT '创建用户ID'")
	private String createuser;

	@Column(name = "updatetime", columnDefinition = "varchar(64) default '' COMMENT '修改时间'")
	private String updatetime;

	@Column(name = "updateuser", columnDefinition = "varchar(64) default '' COMMENT '修改用户ID'")
	private String updateuser;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRtypeole() {
		return rtypeole;
	}

	public void setRtypeole(String rtypeole) {
		this.rtypeole = rtypeole;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

}
