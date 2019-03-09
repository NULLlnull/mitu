package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学院机构信息
 *
 */
public class Xyjgxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//自编机构代码(学院２位+...)
	private String jgdm;
	
	//机构名称
	private String jgmc;
	
	//所属学院
	private String ssxy;
	
	//上级机构
	private Short pid;
	
	//层级
	private String path;
	
	//层次
	private Byte level;
	
	//是否实质机构
	private Byte sfszjg;
	
	//是否教学系部
	private Byte sfjxxb;
	
	//
	private String remark;
	
	//机构电话
	private String jgdh;
	
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
	
	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	
	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	
	public String getSsxy() {
		return ssxy;
	}

	public void setSsxy(String ssxy) {
		this.ssxy = ssxy;
	}
	
	public Short getPid() {
		return pid;
	}

	public void setPid(Short pid) {
		this.pid = pid;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}
	
	public Byte getSfszjg() {
		return sfszjg;
	}

	public void setSfszjg(Byte sfszjg) {
		this.sfszjg = sfszjg;
	}
	
	public Byte getSfjxxb() {
		return sfjxxb;
	}

	public void setSfjxxb(Byte sfjxxb) {
		this.sfjxxb = sfjxxb;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getJgdh() {
		return jgdh;
	}

	public void setJgdh(String jgdh) {
		this.jgdh = jgdh;
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
