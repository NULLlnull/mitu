package com.basedata.model;

import java.io.Serializable;

/**
 * 用户表
 * 
 * @author Administrator
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;

	//
	private String username;

	//
	private String password;

	private String number;

	private String phone;

	private String apptoken;

	private String wxid;

	// 密码错误次数
	private String mmcwcs;

	//
	private Integer status;

	// 最后登录时间
	private Integer last_login_time;

	// 最后登录ip
	private String last_login_ip;

	// 登陆次数
	private Integer login_count;

	// 1为教师，2为学生
	private Integer type;

	// 教师或学生的ID
	private Integer fk;

	private String roleId;

	// 逻辑删除状态0:存在1:删除
	private Integer deltag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMmcwcs() {
		return mmcwcs;
	}

	public void setMmcwcs(String mmcwcs) {
		this.mmcwcs = mmcwcs;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Integer last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	public Integer getLogin_count() {
		return login_count;
	}

	public void setLogin_count(Integer login_count) {
		this.login_count = login_count;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getFk() {
		return fk;
	}

	public void setFk(Integer fk) {
		this.fk = fk;
	}

	public Integer getDeltag() {
		return deltag;
	}

	public void setDeltag(Integer deltag) {
		this.deltag = deltag;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getApptoken() {
		return apptoken;
	}

	public void setApptoken(String apptoken) {
		this.apptoken = apptoken;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
