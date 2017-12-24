package cn.frdz.logistics.server.business.entity.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户
 * 
 * @author sxc
 *
 */
@Entity
@Table(name = "sys_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "uid", columnDefinition = "varchar(64) COMMENT '用户ID'")
	private String uid;

	@Column(name = "phone", columnDefinition = "varchar(16) COMMENT '手机号码'")
	private String phone;

	@Column(name = "password", columnDefinition = "varchar(16) COMMENT '密码'")
	private String password;

	@Column(name = "username", columnDefinition = "varchar(32) COMMENT '用户名'")
	private String username;

	@Column(name = "idcard", columnDefinition = "varchar(32) COMMENT '身份证'")
	private String idcard;

	@Column(name = "iddriver", columnDefinition = "varchar(32) COMMENT '驾驶证'")
	private String iddriver;

	@Column(name = "createtime", columnDefinition = "varchar(16) COMMENT '创建时间'")
	private String createtime;

	@Column(name = "createuser", columnDefinition = "varchar(16) COMMENT '创建用户ID'")
	private String createuser;

	@Column(name = "updatetime", columnDefinition = "varchar(64) default '' COMMENT '修改时间'")
	private String updatetime;

	@Column(name = "updateuser", columnDefinition = "varchar(64) default '' COMMENT '修改用户ID'")
	private String updateuser;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIddriver() {
		return iddriver;
	}

	public void setIddriver(String iddriver) {
		this.iddriver = iddriver;
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
