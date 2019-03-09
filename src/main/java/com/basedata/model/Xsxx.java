package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生信息表
 *
 */
public class Xsxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//学生学号
	private String xsxh;
	
	//姓名
	private String xm;
	
	//性别
	private Byte xb;
	
	//证件类型
	private Byte zjlx;
	
	//
	private String zjlxmc;
	
	//证件号
	private String zjh;
	
	//出生年月
	private Date csny;
	
	//民族代码
	private String mzdm;
	
	//民族名称
	private String mzmc;
	
	//政治面貌代码
	private String zzmmdm;
	
	//政治面貌名称
	private String zzmmmc;
	
	//婚姻状况代码
	private String hyzkdm;
	
	//家庭电话
	private String jtdh;
	
	//家庭地址
	private String jtdz;
	
	//家庭地址邮编
	private String jtdzyb;
	
	//毕业学校
	private String byxx;
	
	//毕业专业
	private String byzy;
	
	//拼音快速索引
	private String pykssy;
	
	//高考考生号
	private String gkksh;
	
	//
	private Short zwh;
	
	//入学年月
	private Date rxny;
	
	//所属学院
	private String ssxy;
	
	//所属系部
	private String ssxb;
	
	//所属系部名称
	private String ssxbmc;
	
	//所属专业
	private String sszy;
	
	//所属专业名称
	private String sszymc;
	
	//所属班级
	private String ssbj;
	
	//所属班级名称
	private String ssbjmc;
	
	//学生类别
	private String xslb;
	
	//学生类别名称
	private String xslbmc;
	
	//学生状态
	private String xszt;
	
	//学籍状态
	private String xjzt;
	
	//毕业状态
	private String byzt;
	
	//联系人姓名
	private String lxrxm;
	
	//联系人电话
	private String lxrdh;
	
	//操作人员
	private String czry;
	
	//操作人姓名
	private String czrxm;
	
	//住宿情况 1校内住宿 2走读 3校外住宿
	private String zsqk;
	
	//住宿情况名称
	private String zsqkmc;
	
	//个人照片地址
	private String zp;
	
	//银行名称
	private String yhmc;
	
	//银行帐号
	private String yhzh;
	
	//生源地
	private String sydq;
	
	//生源地名称
	private String sydqmc;
	
	//住宿所属建筑楼
	private String zsssjzl;
	
	//住宿所属房间号
	private String zsssfjh;
	
	//住宿所属建筑楼名称
	private String zsssjzlmc;
	
	//港澳台侨外
	private String gatqwdm;
	
	//
	private String gatqwmc;
	
	//是否随迁子女
	private String sfsqzn;
	
	//出生地区
	private String csdq;
	
	//
	private String csdqmc;
	
	//户口地址
	private String hkdz;
	
	//户口所属派出所
	private String hksspcs;
	
	//户口所在地区
	private String hkszdq;
	
	//
	private String hkszdqmc;
	
	//健康状况
	private String jkzkdm;
	
	//
	private String jkzkmc;
	
	//住址地区
	private String zzdq;
	
	//
	private String zzdqmc;
	
	//居住地类型
	private String jzdlxdm;
	
	//
	private String jzdlxmc;
	
	//是否独生子女
	private String sfdszn;
	
	//
	private Byte deltag;
	
	//
	private String remark;
	
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
	
	public String getXsxh() {
		return xsxh;
	}

	public void setXsxh(String xsxh) {
		this.xsxh = xsxh;
	}
	
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}
	
	public Byte getXb() {
		return xb;
	}

	public void setXb(Byte xb) {
		this.xb = xb;
	}
	
	public Byte getZjlx() {
		return zjlx;
	}

	public void setZjlx(Byte zjlx) {
		this.zjlx = zjlx;
	}
	
	public String getZjlxmc() {
		return zjlxmc;
	}

	public void setZjlxmc(String zjlxmc) {
		this.zjlxmc = zjlxmc;
	}
	
	public String getZjh() {
		return zjh;
	}

	public void setZjh(String zjh) {
		this.zjh = zjh;
	}
	
	public Date getCsny() {
		return csny;
	}

	public void setCsny(Date csny) {
		this.csny = csny;
	}
	
	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	
	public String getMzmc() {
		return mzmc;
	}

	public void setMzmc(String mzmc) {
		this.mzmc = mzmc;
	}
	
	public String getZzmmdm() {
		return zzmmdm;
	}

	public void setZzmmdm(String zzmmdm) {
		this.zzmmdm = zzmmdm;
	}
	
	public String getZzmmmc() {
		return zzmmmc;
	}

	public void setZzmmmc(String zzmmmc) {
		this.zzmmmc = zzmmmc;
	}
	
	public String getHyzkdm() {
		return hyzkdm;
	}

	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}
	
	public String getJtdh() {
		return jtdh;
	}

	public void setJtdh(String jtdh) {
		this.jtdh = jtdh;
	}
	
	public String getJtdz() {
		return jtdz;
	}

	public void setJtdz(String jtdz) {
		this.jtdz = jtdz;
	}
	
	public String getJtdzyb() {
		return jtdzyb;
	}

	public void setJtdzyb(String jtdzyb) {
		this.jtdzyb = jtdzyb;
	}
	
	public String getByxx() {
		return byxx;
	}

	public void setByxx(String byxx) {
		this.byxx = byxx;
	}
	
	public String getByzy() {
		return byzy;
	}

	public void setByzy(String byzy) {
		this.byzy = byzy;
	}
	
	public String getPykssy() {
		return pykssy;
	}

	public void setPykssy(String pykssy) {
		this.pykssy = pykssy;
	}
	
	public String getGkksh() {
		return gkksh;
	}

	public void setGkksh(String gkksh) {
		this.gkksh = gkksh;
	}
	
	public Short getZwh() {
		return zwh;
	}

	public void setZwh(Short zwh) {
		this.zwh = zwh;
	}
	
	public Date getRxny() {
		return rxny;
	}

	public void setRxny(Date rxny) {
		this.rxny = rxny;
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
	
	public String getSsbj() {
		return ssbj;
	}

	public void setSsbj(String ssbj) {
		this.ssbj = ssbj;
	}
	
	public String getSsbjmc() {
		return ssbjmc;
	}

	public void setSsbjmc(String ssbjmc) {
		this.ssbjmc = ssbjmc;
	}
	
	public String getXslb() {
		return xslb;
	}

	public void setXslb(String xslb) {
		this.xslb = xslb;
	}
	
	public String getXslbmc() {
		return xslbmc;
	}

	public void setXslbmc(String xslbmc) {
		this.xslbmc = xslbmc;
	}
	
	public String getXszt() {
		return xszt;
	}

	public void setXszt(String xszt) {
		this.xszt = xszt;
	}
	
	public String getXjzt() {
		return xjzt;
	}

	public void setXjzt(String xjzt) {
		this.xjzt = xjzt;
	}
	
	public String getByzt() {
		return byzt;
	}

	public void setByzt(String byzt) {
		this.byzt = byzt;
	}
	
	public String getLxrxm() {
		return lxrxm;
	}

	public void setLxrxm(String lxrxm) {
		this.lxrxm = lxrxm;
	}
	
	public String getLxrdh() {
		return lxrdh;
	}

	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}
	
	public String getCzry() {
		return czry;
	}

	public void setCzry(String czry) {
		this.czry = czry;
	}
	
	public String getCzrxm() {
		return czrxm;
	}

	public void setCzrxm(String czrxm) {
		this.czrxm = czrxm;
	}
	
	public String getZsqk() {
		return zsqk;
	}

	public void setZsqk(String zsqk) {
		this.zsqk = zsqk;
	}
	
	public String getZsqkmc() {
		return zsqkmc;
	}

	public void setZsqkmc(String zsqkmc) {
		this.zsqkmc = zsqkmc;
	}
	
	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}
	
	public String getYhmc() {
		return yhmc;
	}

	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}
	
	public String getYhzh() {
		return yhzh;
	}

	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}
	
	public String getSydq() {
		return sydq;
	}

	public void setSydq(String sydq) {
		this.sydq = sydq;
	}
	
	public String getSydqmc() {
		return sydqmc;
	}

	public void setSydqmc(String sydqmc) {
		this.sydqmc = sydqmc;
	}
	
	public String getZsssjzl() {
		return zsssjzl;
	}

	public void setZsssjzl(String zsssjzl) {
		this.zsssjzl = zsssjzl;
	}
	
	public String getZsssfjh() {
		return zsssfjh;
	}

	public void setZsssfjh(String zsssfjh) {
		this.zsssfjh = zsssfjh;
	}
	
	public String getZsssjzlmc() {
		return zsssjzlmc;
	}

	public void setZsssjzlmc(String zsssjzlmc) {
		this.zsssjzlmc = zsssjzlmc;
	}
	
	public String getGatqwdm() {
		return gatqwdm;
	}

	public void setGatqwdm(String gatqwdm) {
		this.gatqwdm = gatqwdm;
	}
	
	public String getGatqwmc() {
		return gatqwmc;
	}

	public void setGatqwmc(String gatqwmc) {
		this.gatqwmc = gatqwmc;
	}
	
	public String getSfsqzn() {
		return sfsqzn;
	}

	public void setSfsqzn(String sfsqzn) {
		this.sfsqzn = sfsqzn;
	}
	
	public String getCsdq() {
		return csdq;
	}

	public void setCsdq(String csdq) {
		this.csdq = csdq;
	}
	
	public String getCsdqmc() {
		return csdqmc;
	}

	public void setCsdqmc(String csdqmc) {
		this.csdqmc = csdqmc;
	}
	
	public String getHkdz() {
		return hkdz;
	}

	public void setHkdz(String hkdz) {
		this.hkdz = hkdz;
	}
	
	public String getHksspcs() {
		return hksspcs;
	}

	public void setHksspcs(String hksspcs) {
		this.hksspcs = hksspcs;
	}
	
	public String getHkszdq() {
		return hkszdq;
	}

	public void setHkszdq(String hkszdq) {
		this.hkszdq = hkszdq;
	}
	
	public String getHkszdqmc() {
		return hkszdqmc;
	}

	public void setHkszdqmc(String hkszdqmc) {
		this.hkszdqmc = hkszdqmc;
	}
	
	public String getJkzkdm() {
		return jkzkdm;
	}

	public void setJkzkdm(String jkzkdm) {
		this.jkzkdm = jkzkdm;
	}
	
	public String getJkzkmc() {
		return jkzkmc;
	}

	public void setJkzkmc(String jkzkmc) {
		this.jkzkmc = jkzkmc;
	}
	
	public String getZzdq() {
		return zzdq;
	}

	public void setZzdq(String zzdq) {
		this.zzdq = zzdq;
	}
	
	public String getZzdqmc() {
		return zzdqmc;
	}

	public void setZzdqmc(String zzdqmc) {
		this.zzdqmc = zzdqmc;
	}
	
	public String getJzdlxdm() {
		return jzdlxdm;
	}

	public void setJzdlxdm(String jzdlxdm) {
		this.jzdlxdm = jzdlxdm;
	}
	
	public String getJzdlxmc() {
		return jzdlxmc;
	}

	public void setJzdlxmc(String jzdlxmc) {
		this.jzdlxmc = jzdlxmc;
	}
	
	public String getSfdszn() {
		return sfdszn;
	}

	public void setSfdszn(String sfdszn) {
		this.sfdszn = sfdszn;
	}
	
	public Byte getDeltag() {
		return deltag;
	}

	public void setDeltag(Byte deltag) {
		this.deltag = deltag;
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
