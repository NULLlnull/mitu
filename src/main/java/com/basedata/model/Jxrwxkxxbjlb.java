package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 选课信息开设班级列表
 *
 */
public class Jxrwxkxxbjlb implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//教学任务ID
	private Integer jxrwid;
	
	//
	private Integer xkxxid;
	
	//
	private String bjdm;
	
	//
	private String remark;
	
	//
	private Integer create_time;
	
	//
	private Integer update_time;
	
	//
	private Byte deltag;
	
	//操作人员
	private String oprybh;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getJxrwid() {
		return jxrwid;
	}

	public void setJxrwid(Integer jxrwid) {
		this.jxrwid = jxrwid;
	}
	
	public Integer getXkxxid() {
		return xkxxid;
	}

	public void setXkxxid(Integer xkxxid) {
		this.xkxxid = xkxxid;
	}
	
	public String getBjdm() {
		return bjdm;
	}

	public void setBjdm(String bjdm) {
		this.bjdm = bjdm;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
	
	public Byte getDeltag() {
		return deltag;
	}

	public void setDeltag(Byte deltag) {
		this.deltag = deltag;
	}
	
	public String getOprybh() {
		return oprybh;
	}

	public void setOprybh(String oprybh) {
		this.oprybh = oprybh;
	}
	

}
