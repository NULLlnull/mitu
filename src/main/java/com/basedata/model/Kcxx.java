package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程信息表
 *
 */
public class Kcxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//所属学院
	private String ssxy;
	
	//课程分类
	private String kcfl;
	
	//自编课程代码(学院2分类2代码6高低位1)
	private String kcdm;
	
	//课程名称
	private String kcmc;
	
	//课程简称
	private String kcjc;
	
	//课程英文名称
	private String kcywmc;
	
	//所属教研室
	private String ssjys;
	
	//
	private String ssjysmc;
	
	//拼音快速索引
	private String pykssy;
	
	//非教学任务课程
	private Byte fjxrwkc;
	
	//默认空闲课程
	private Byte mrkxkc;
	
	//
	private String remark;
	
	//
	private Integer create_time;
	
	//
	private Integer update_time;
	
	//操作人员
	private String oprybh;
	
	//帖子数量
	private Integer tzsl;
	
	//最后发布时间
	private Date zhfbsj;
	

	
	public String getSsxy() {
		return ssxy;
	}

	public void setSsxy(String ssxy) {
		this.ssxy = ssxy;
	}
	
	public String getKcfl() {
		return kcfl;
	}

	public void setKcfl(String kcfl) {
		this.kcfl = kcfl;
	}
	
	public String getKcdm() {
		return kcdm;
	}

	public void setKcdm(String kcdm) {
		this.kcdm = kcdm;
	}
	
	public String getKcmc() {
		return kcmc;
	}

	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}
	
	public String getKcjc() {
		return kcjc;
	}

	public void setKcjc(String kcjc) {
		this.kcjc = kcjc;
	}
	
	public String getKcywmc() {
		return kcywmc;
	}

	public void setKcywmc(String kcywmc) {
		this.kcywmc = kcywmc;
	}
	
	public String getSsjys() {
		return ssjys;
	}

	public void setSsjys(String ssjys) {
		this.ssjys = ssjys;
	}
	
	public String getSsjysmc() {
		return ssjysmc;
	}

	public void setSsjysmc(String ssjysmc) {
		this.ssjysmc = ssjysmc;
	}
	
	public String getPykssy() {
		return pykssy;
	}

	public void setPykssy(String pykssy) {
		this.pykssy = pykssy;
	}
	
	public Byte getFjxrwkc() {
		return fjxrwkc;
	}

	public void setFjxrwkc(Byte fjxrwkc) {
		this.fjxrwkc = fjxrwkc;
	}
	
	public Byte getMrkxkc() {
		return mrkxkc;
	}

	public void setMrkxkc(Byte mrkxkc) {
		this.mrkxkc = mrkxkc;
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
	
	public String getOprybh() {
		return oprybh;
	}

	public void setOprybh(String oprybh) {
		this.oprybh = oprybh;
	}
	
	public Integer getTzsl() {
		return tzsl;
	}

	public void setTzsl(Integer tzsl) {
		this.tzsl = tzsl;
	}
	
	public Date getZhfbsj() {
		return zhfbsj;
	}

	public void setZhfbsj(Date zhfbsj) {
		this.zhfbsj = zhfbsj;
	}
	

}
