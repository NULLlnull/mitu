package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级信息表
 *
 */
public class Bjxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//所属学院
	private String ssxy;
	
	//所属校区
	private String ssxq;
	
	//所属校区名称
	private String ssxqmc;
	
	//所属系部
	private String ssxb;
	
	//所属系部名称
	private String ssxbmc;
	
	//所属专业
	private String sszy;
	
	//所属专业名称
	private String sszymc;
	
	//培养对象
	private String pydx;
	
	//培养对象名称
	private String pydxmc;
	
	//培养层次代码
	private String pycc;
	
	//培养层次名称
	private String pyccmc;
	
	//专业方向
	private String zyfx;
	
	//专业方向名称
	private String zyfxmc;
	
	//自编班级代码专业7年份4代码2
	private String bjdm;
	
	//班级名称
	private String bjmc;
	
	//班级简称
	private String bjjc;
	
	//年级
	private Short nj;
	
	//学制
	private Byte xz;
	
	//
	private String xzshow;
	
	//建立时间
	private Date jlsj;
	
	//毕业届别
	private Short byjb;
	
	//班级在校人数
	private Short bjzxrs;
	
	//班级在校人数_男
	private Short bjzxrs_m;
	
	//班级在校人数_女
	private Short bjzxrs_f;
	
	//班级实际在校人数
	private Short bjsjzxrs;
	
	//班级实际在校人数_男
	private Short bjsjzxrs_m;
	
	//班级实际在校人数_女
	private Short bjsjzxrs_f;
	
	//
	private String remark;
	
	//停用标志
	private Byte tybz;
	
	//辅导员
	private String fdy;
	
	//辅导员姓名
	private String fdyxm;
	
	//学委
	private String xw;
	
	//学委姓名
	private String xwxm;
	
	//学委辅助考勤开放
	private Byte xwfzkqkf;
	
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
	
	public String getSsxb() {
		return ssxb;
	}

	public void setSsxb(String ssxb) {
		this.ssxb = ssxb;
	}
	
	public String getSsxbmc() {
		return ssxbmc;
	}

	public void setSsxbmc(String ssxbmc) {
		this.ssxbmc = ssxbmc;
	}
	
	public String getSszy() {
		return sszy;
	}

	public void setSszy(String sszy) {
		this.sszy = sszy;
	}
	
	public String getSszymc() {
		return sszymc;
	}

	public void setSszymc(String sszymc) {
		this.sszymc = sszymc;
	}
	
	public String getPydx() {
		return pydx;
	}

	public void setPydx(String pydx) {
		this.pydx = pydx;
	}
	
	public String getPydxmc() {
		return pydxmc;
	}

	public void setPydxmc(String pydxmc) {
		this.pydxmc = pydxmc;
	}
	
	public String getPycc() {
		return pycc;
	}

	public void setPycc(String pycc) {
		this.pycc = pycc;
	}
	
	public String getPyccmc() {
		return pyccmc;
	}

	public void setPyccmc(String pyccmc) {
		this.pyccmc = pyccmc;
	}
	
	public String getZyfx() {
		return zyfx;
	}

	public void setZyfx(String zyfx) {
		this.zyfx = zyfx;
	}
	
	public String getZyfxmc() {
		return zyfxmc;
	}

	public void setZyfxmc(String zyfxmc) {
		this.zyfxmc = zyfxmc;
	}
	
	public String getBjdm() {
		return bjdm;
	}

	public void setBjdm(String bjdm) {
		this.bjdm = bjdm;
	}
	
	public String getBjmc() {
		return bjmc;
	}

	public void setBjmc(String bjmc) {
		this.bjmc = bjmc;
	}
	
	public String getBjjc() {
		return bjjc;
	}

	public void setBjjc(String bjjc) {
		this.bjjc = bjjc;
	}
	
	public Short getNj() {
		return nj;
	}

	public void setNj(Short nj) {
		this.nj = nj;
	}
	
	public Byte getXz() {
		return xz;
	}

	public void setXz(Byte xz) {
		this.xz = xz;
	}
	
	public String getXzshow() {
		return xzshow;
	}

	public void setXzshow(String xzshow) {
		this.xzshow = xzshow;
	}
	
	public Date getJlsj() {
		return jlsj;
	}

	public void setJlsj(Date jlsj) {
		this.jlsj = jlsj;
	}
	
	public Short getByjb() {
		return byjb;
	}

	public void setByjb(Short byjb) {
		this.byjb = byjb;
	}
	
	public Short getBjzxrs() {
		return bjzxrs;
	}

	public void setBjzxrs(Short bjzxrs) {
		this.bjzxrs = bjzxrs;
	}
	
	public Short getBjzxrs_m() {
		return bjzxrs_m;
	}

	public void setBjzxrs_m(Short bjzxrs_m) {
		this.bjzxrs_m = bjzxrs_m;
	}
	
	public Short getBjzxrs_f() {
		return bjzxrs_f;
	}

	public void setBjzxrs_f(Short bjzxrs_f) {
		this.bjzxrs_f = bjzxrs_f;
	}
	
	public Short getBjsjzxrs() {
		return bjsjzxrs;
	}

	public void setBjsjzxrs(Short bjsjzxrs) {
		this.bjsjzxrs = bjsjzxrs;
	}
	
	public Short getBjsjzxrs_m() {
		return bjsjzxrs_m;
	}

	public void setBjsjzxrs_m(Short bjsjzxrs_m) {
		this.bjsjzxrs_m = bjsjzxrs_m;
	}
	
	public Short getBjsjzxrs_f() {
		return bjsjzxrs_f;
	}

	public void setBjsjzxrs_f(Short bjsjzxrs_f) {
		this.bjsjzxrs_f = bjsjzxrs_f;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Byte getTybz() {
		return tybz;
	}

	public void setTybz(Byte tybz) {
		this.tybz = tybz;
	}
	
	public String getFdy() {
		return fdy;
	}

	public void setFdy(String fdy) {
		this.fdy = fdy;
	}
	
	public String getFdyxm() {
		return fdyxm;
	}

	public void setFdyxm(String fdyxm) {
		this.fdyxm = fdyxm;
	}
	
	public String getXw() {
		return xw;
	}

	public void setXw(String xw) {
		this.xw = xw;
	}
	
	public String getXwxm() {
		return xwxm;
	}

	public void setXwxm(String xwxm) {
		this.xwxm = xwxm;
	}
	
	public Byte getXwfzkqkf() {
		return xwfzkqkf;
	}

	public void setXwfzkqkf(Byte xwfzkqkf) {
		this.xwfzkqkf = xwfzkqkf;
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
