package com.basedata.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 专业培养计划表
 *
 */
public class Zypyjhzb implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//所属专业
	private String sszy;
	
	//开设年级
	private Short ksnj;
	
	//计划类型
	private String jhlx;
	
	//专业方向ID
	private String zyfx;
	
	//专业方向名称
	private String zyfxmc;
	
	//考核方式
	private String khfs;
	
	//学期总学时
	private BigDecimal xqzxs;
	
	//讲课学时
	private BigDecimal jkxs;
	
	//实验学时
	private BigDecimal syxs;
	
	//上机学时
	private BigDecimal sjxs;
	
	//周学时
	private BigDecimal zxs;
	
	//周数
	private Byte zs;
	
	//课程学分
	private Byte kcxf;
	
	//所属学院
	private String ssxy;
	
	//所属系部
	private String ssxb;
	
	//系部名称
	private String ssxbmc;
	
	//所属教研室
	private String ssjys;
	
	//所属教研室名称
	private String ssjysmc;
	
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
	
	public String getJhlx() {
		return jhlx;
	}

	public void setJhlx(String jhlx) {
		this.jhlx = jhlx;
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
	
	public String getKhfs() {
		return khfs;
	}

	public void setKhfs(String khfs) {
		this.khfs = khfs;
	}
	
	public BigDecimal getXqzxs() {
		return xqzxs;
	}

	public void setXqzxs(BigDecimal xqzxs) {
		this.xqzxs = xqzxs;
	}
	
	public BigDecimal getJkxs() {
		return jkxs;
	}

	public void setJkxs(BigDecimal jkxs) {
		this.jkxs = jkxs;
	}
	
	public BigDecimal getSyxs() {
		return syxs;
	}

	public void setSyxs(BigDecimal syxs) {
		this.syxs = syxs;
	}
	
	public BigDecimal getSjxs() {
		return sjxs;
	}

	public void setSjxs(BigDecimal sjxs) {
		this.sjxs = sjxs;
	}
	
	public BigDecimal getZxs() {
		return zxs;
	}

	public void setZxs(BigDecimal zxs) {
		this.zxs = zxs;
	}
	
	public Byte getZs() {
		return zs;
	}

	public void setZs(Byte zs) {
		this.zs = zs;
	}
	
	public Byte getKcxf() {
		return kcxf;
	}

	public void setKcxf(Byte kcxf) {
		this.kcxf = kcxf;
	}
	
	public String getSsxy() {
		return ssxy;
	}

	public void setSsxy(String ssxy) {
		this.ssxy = ssxy;
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
