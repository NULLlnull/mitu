package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学院信息表
 *
 */
public class Xyxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//部属代码
	private String bsdm;
	
	//自编学院代码
	private String xydm;
	
	//学院名称
	private String xymc;
	
	//
	private String remark;
	
	//当前学年
	private String dqxn;
	
	//当前学期
	private String dqxq;
	
	//选课学年
	private String xkxn;
	
	//选课学期
	private String xkxq;
	
	//
	private Byte deltag;
	
	//
	private Integer create_time;
	
	//
	private Integer update_time;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBsdm() {
		return bsdm;
	}

	public void setBsdm(String bsdm) {
		this.bsdm = bsdm;
	}
	
	public String getXydm() {
		return xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}
	
	public String getXymc() {
		return xymc;
	}

	public void setXymc(String xymc) {
		this.xymc = xymc;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getDqxn() {
		return dqxn;
	}

	public void setDqxn(String dqxn) {
		this.dqxn = dqxn;
	}
	
	public String getDqxq() {
		return dqxq;
	}

	public void setDqxq(String dqxq) {
		this.dqxq = dqxq;
	}
	
	public String getXkxn() {
		return xkxn;
	}

	public void setXkxn(String xkxn) {
		this.xkxn = xkxn;
	}
	
	public String getXkxq() {
		return xkxq;
	}

	public void setXkxq(String xkxq) {
		this.xkxq = xkxq;
	}
	
	public Byte getDeltag() {
		return deltag;
	}

	public void setDeltag(Byte deltag) {
		this.deltag = deltag;
	}
	
	public Integer getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Integer create_time) {
		this.create_time = create_time;
	}
	
	public Integer getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Integer update_time) {
		this.update_time = update_time;
	}
	

}
