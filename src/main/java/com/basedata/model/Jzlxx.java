package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 建筑楼信息
 *
 */
public class Jzlxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//自编建筑楼代码(学院２位校区代码２位建筑楼代码3位)
	private String jzldm;
	
	//建筑楼名称
	private String jzlmc;
	
	//所属学院
	private String ssxy;
	
	//所属校区
	private String ssxq;
	
	//是否住宿楼
	private Byte sfzsl;
	
	//
	private String remark;
	
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
	
	public String getJzldm() {
		return jzldm;
	}

	public void setJzldm(String jzldm) {
		this.jzldm = jzldm;
	}
	
	public String getJzlmc() {
		return jzlmc;
	}

	public void setJzlmc(String jzlmc) {
		this.jzlmc = jzlmc;
	}
	
	public String getSsxy() {
		return ssxy;
	}

	public void setSsxy(String ssxy) {
		this.ssxy = ssxy;
	}
	
	public String getSsxq() {
		return ssxq;
	}

	public void setSsxq(String ssxq) {
		this.ssxq = ssxq;
	}
	
	public Byte getSfzsl() {
		return sfzsl;
	}

	public void setSfzsl(Byte sfzsl) {
		this.sfzsl = sfzsl;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
