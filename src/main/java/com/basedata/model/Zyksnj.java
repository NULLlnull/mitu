package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 专业开设年级
 *
 */
public class Zyksnj implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//所属专业
	private String sszy;
	
	//开设年级
	private Short ksnj;
	
	//
	private String remark;
	
	//
	private Integer create_time;
	
	//
	private Integer update_time;
	

	
	public String getSszy() {
		return sszy;
	}

	public void setSszy(String sszy) {
		this.sszy = sszy;
	}
	
	public Short getKsnj() {
		return ksnj;
	}

	public void setKsnj(Short ksnj) {
		this.ksnj = ksnj;
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
	

}
