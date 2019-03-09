package com.basedata.model;

import java.io.Serializable;

/**
 * 教室实验室信息
 *
 */
public class Jssysxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//类别(1校内2校外)
	private Byte lb;
	
	//教室实验室类型
	private String lx;
	
	//类别1位+自编教室实验室代码(建筑楼代码7位+4位顺序号)
	private String jssysdm;
	
	//名称
	private String jssysmc;
	
	//简称
	private String jssysjc;
	
	//所属学院
	private String ssxy;
	
	//所属校区
	private String ssxq;
	
	//所属校区名称
	private String ssxqmc;
	
	//所属建筑楼
	private String ssjzl;
	
	//所属建筑楼名称
	private String ssjzlmc;
	
	//层号
	private Short ch;
	
	//门牌号 
	private String mph;
	
	//学生容量
	private Short xsrl;
	
	//班级容量
	private Short bjrl;
	
	//是否有多媒体设备(电脑)
	private Byte sfydmtsb;
	
	//是否有投影设备
	private Byte sfytyysb;
	
	//是否有空调设备
	private Byte sfyktsb;
	
	//是否有录制设备
	private Byte sfylzsb;
	
	//是否有远程视频设备
	private Byte sfyycspsb;
	
	//管辖机构(多机构,分割)
	private String gxjgdm;
	
	//管辖机构(多机构,分割)
	private String gxjgmc;
	
	//操作人员
	private String oprybh;
	
	//开放自选标志
	private Byte kfzxbz;
	
	//场地管理员工号
	private String cdglygh;
	
	//场地管理员姓名
	private String cdglyxm;
	
	//分配班级代码
	private String fbbjdm;
	
	//分配班级名称
	private String fbbjmc;
	
	//停用标志
	private Byte tybz;
	
	//场地学生管理员
	private String cdxsgly;
	
	//场地学生管理员
	private String cdxsglyxm;
	
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
	
	public Byte getLb() {
		return lb;
	}

	public void setLb(Byte lb) {
		this.lb = lb;
	}
	
	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}
	
	public String getJssysdm() {
		return jssysdm;
	}

	public void setJssysdm(String jssysdm) {
		this.jssysdm = jssysdm;
	}
	
	public String getJssysmc() {
		return jssysmc;
	}

	public void setJssysmc(String jssysmc) {
		this.jssysmc = jssysmc;
	}
	
	public String getJssysjc() {
		return jssysjc;
	}

	public void setJssysjc(String jssysjc) {
		this.jssysjc = jssysjc;
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
	
	public String getSsxqmc() {
		return ssxqmc;
	}

	public void setSsxqmc(String ssxqmc) {
		this.ssxqmc = ssxqmc;
	}
	
	public String getSsjzl() {
		return ssjzl;
	}

	public void setSsjzl(String ssjzl) {
		this.ssjzl = ssjzl;
	}
	
	public String getSsjzlmc() {
		return ssjzlmc;
	}

	public void setSsjzlmc(String ssjzlmc) {
		this.ssjzlmc = ssjzlmc;
	}
	
	public Short getCh() {
		return ch;
	}

	public void setCh(Short ch) {
		this.ch = ch;
	}
	
	public String getMph() {
		return mph;
	}

	public void setMph(String mph) {
		this.mph = mph;
	}
	
	public Short getXsrl() {
		return xsrl;
	}

	public void setXsrl(Short xsrl) {
		this.xsrl = xsrl;
	}
	
	public Short getBjrl() {
		return bjrl;
	}

	public void setBjrl(Short bjrl) {
		this.bjrl = bjrl;
	}
	
	public Byte getSfydmtsb() {
		return sfydmtsb;
	}

	public void setSfydmtsb(Byte sfydmtsb) {
		this.sfydmtsb = sfydmtsb;
	}
	
	public Byte getSfytyysb() {
		return sfytyysb;
	}

	public void setSfytyysb(Byte sfytyysb) {
		this.sfytyysb = sfytyysb;
	}
	
	public Byte getSfyktsb() {
		return sfyktsb;
	}

	public void setSfyktsb(Byte sfyktsb) {
		this.sfyktsb = sfyktsb;
	}
	
	public Byte getSfylzsb() {
		return sfylzsb;
	}

	public void setSfylzsb(Byte sfylzsb) {
		this.sfylzsb = sfylzsb;
	}
	
	public Byte getSfyycspsb() {
		return sfyycspsb;
	}

	public void setSfyycspsb(Byte sfyycspsb) {
		this.sfyycspsb = sfyycspsb;
	}
	
	public String getGxjgdm() {
		return gxjgdm;
	}

	public void setGxjgdm(String gxjgdm) {
		this.gxjgdm = gxjgdm;
	}
	
	public String getGxjgmc() {
		return gxjgmc;
	}

	public void setGxjgmc(String gxjgmc) {
		this.gxjgmc = gxjgmc;
	}
	
	public String getOprybh() {
		return oprybh;
	}

	public void setOprybh(String oprybh) {
		this.oprybh = oprybh;
	}
	
	public Byte getKfzxbz() {
		return kfzxbz;
	}

	public void setKfzxbz(Byte kfzxbz) {
		this.kfzxbz = kfzxbz;
	}
	
	public String getCdglygh() {
		return cdglygh;
	}

	public void setCdglygh(String cdglygh) {
		this.cdglygh = cdglygh;
	}
	
	public String getCdglyxm() {
		return cdglyxm;
	}

	public void setCdglyxm(String cdglyxm) {
		this.cdglyxm = cdglyxm;
	}
	
	public String getFbbjdm() {
		return fbbjdm;
	}

	public void setFbbjdm(String fbbjdm) {
		this.fbbjdm = fbbjdm;
	}
	
	public String getFbbjmc() {
		return fbbjmc;
	}

	public void setFbbjmc(String fbbjmc) {
		this.fbbjmc = fbbjmc;
	}
	
	public Byte getTybz() {
		return tybz;
	}

	public void setTybz(Byte tybz) {
		this.tybz = tybz;
	}
	
	public String getCdxsgly() {
		return cdxsgly;
	}

	public void setCdxsgly(String cdxsgly) {
		this.cdxsgly = cdxsgly;
	}
	
	public String getCdxsglyxm() {
		return cdxsglyxm;
	}

	public void setCdxsglyxm(String cdxsglyxm) {
		this.cdxsglyxm = cdxsglyxm;
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
