package cn.frdz.logistics.server.business.entity.sys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 资源
 * 
 * @author sxc
 *
 */
@Entity
@Table(name = "sys_resource")
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "resid", columnDefinition = "varchar(64) COMMENT '资源ID'")
	private String resid;

	@Column(name = "parentid", columnDefinition = "varchar(64) default '' COMMENT '父ID'")
	private String parentid;

	@Column(name = "resname", columnDefinition = "varchar(64) COMMENT '资源名'")
	private String resname;

	@Column(name = "link", columnDefinition = "varchar(2048) default '' COMMENT '资源链接'")
	private String link;

	@Column(name = "icon", columnDefinition = "varchar(64) default '' COMMENT '图标'")
	private String icon;

	@Column(name = "restype", columnDefinition = "varchar(64) default '' COMMENT '类型'")
	private String restype;

	@Column(name = "seq", columnDefinition = "int(10) default 0 COMMENT '排序'")
	private int seq;

	@Column(name = "createtime", columnDefinition = "varchar(16) COMMENT '创建时间'")
	private String createtime;

	@Column(name = "createuser", columnDefinition = "varchar(16) COMMENT '创建用户ID'")
	private String createuser;

	@Column(name = "updatetime", columnDefinition = "varchar(64) default '' COMMENT '修改时间'")
	private String updatetime;

	@Column(name = "updateuser", columnDefinition = "varchar(64) default '' COMMENT '修改用户ID'")
	private String updateuser;

	public String getResid() {
		return resid;
	}

	public void setResid(String resid) {
		this.resid = resid;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getResname() {
		return resname;
	}

	public void setResname(String resname) {
		this.resname = resname;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRestype() {
		return restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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
