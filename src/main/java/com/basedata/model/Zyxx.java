package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 专业信息表
 *
 */
public class Zyxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//院内专业代码(系代码4专业代码3)
	private String ynzydm;
	
	//招生专业代码
	private String zszydm;
	
	//院内专业名称
	private String ynzymc;
	
	//招生专业名称
	private String zszymc;
	
	//所属系部
	private String ssxb;
	private String ssxbName;
	
	//所属学院
	private String ssxy;
	
	//培养对象
	private String pydxDm;
	private String pydxName;
	
	//培养层次
	private String pyccDm;
	private String pyccName;
	
	//学制
	private Byte xz;
	
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
	
	public String getYnzydm() {
		return ynzydm;
	}

	public void setYnzydm(String ynzydm) {
		this.ynzydm = ynzydm;
	}
	
	public String getZszydm() {
		return zszydm;
	}

	public void setZszydm(String zszydm) {
		this.zszydm = zszydm;
	}
	
	public String getYnzymc() {
		return ynzymc;
	}

	public void setYnzymc(String ynzymc) {
		this.ynzymc = ynzymc;
	}
	
	public String getZszymc() {
		return zszymc;
	}

	public void setZszymc(String zszymc) {
		this.zszymc = zszymc;
	}
	
	public String getSsxb() {
		return ssxb;
	}

	public void setSsxb(String ssxb) {
		this.ssxb = ssxb;
	}
	
	public String getSsxy() {
		return ssxy;
	}

	public void setSsxy(String ssxy) {
		this.ssxy = ssxy;
	}

	public String getSsxbName() {
		return ssxbName;
	}

	public void setSsxbName(String ssxbName) {
		this.ssxbName = ssxbName;
	}

	public String getPydxDm() {
		return pydxDm;
	}

	public void setPydxDm(String pydxDm) {
		this.pydxDm = pydxDm;
	}

	public String getPydxName() {
		return pydxName;
	}

	public void setPydxName(String pydxName) {
		this.pydxName = pydxName;
	}

	public String getPyccDm() {
		return pyccDm;
	}

	public void setPyccDm(String pyccDm) {
		this.pyccDm = pyccDm;
	}

	public String getPyccName() {
		return pyccName;
	}

	public void setPyccName(String pyccName) {
		this.pyccName = pyccName;
	}

	public Byte getXz() {
		return xz;
	}

	public void setXz(Byte xz) {
		this.xz = xz;
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
