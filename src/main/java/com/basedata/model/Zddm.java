package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典代码表
 *
 */
public class Zddm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//所属字典类别
	private String sszdlb;
	
	//字典代码
	private String dmbh;
	
	//字典代码名称
	private String dmmc;
	
	//排序
	private Short sort;
	
	//拼音首字母快速索引
	private String pykssy;
	
	//显示标志 1显示 0 不显示
	private Byte xsbz;
	
	//废弃标志 1废弃 0启用
	private Byte fqbz;
	
	//
	private String remark;
	
	//
	private Date create_time;
	
	//
	private Date update_time;
	
	//
	private Byte deltag;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSszdlb() {
		return sszdlb;
	}

	public void setSszdlb(String sszdlb) {
		this.sszdlb = sszdlb;
	}
	
	public String getDmbh() {
		return dmbh;
	}

	public void setDmbh(String dmbh) {
		this.dmbh = dmbh;
	}
	
	public String getDmmc() {
		return dmmc;
	}

	public void setDmmc(String dmmc) {
		this.dmmc = dmmc;
	}
	
	public Short getSort() {
		return sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}
	
	public String getPykssy() {
		return pykssy;
	}

	public void setPykssy(String pykssy) {
		this.pykssy = pykssy;
	}
	
	public Byte getXsbz() {
		return xsbz;
	}

	public void setXsbz(Byte xsbz) {
		this.xsbz = xsbz;
	}
	
	public Byte getFqbz() {
		return fqbz;
	}

	public void setFqbz(Byte fqbz) {
		this.fqbz = fqbz;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	public Byte getDeltag() {
		return deltag;
	}

	public void setDeltag(Byte deltag) {
		this.deltag = deltag;
	}
	

}
