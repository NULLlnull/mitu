package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 人员基础信息表
 *
 */
public class Ryjcxx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//
	private String apptoken;
	
	//人员编号
	private String rybh;
	
	//姓名
	private String xm;
	
	//性别
	private Long xb;
	
	//证件类型
	private Long zjlx;
	
	//
	private String zjlxmc;
	
	//证件号
	private String zjh;
	
	//户口类别代码
	private String hklbdm;
	
	//户口类别名称
	private String hklbmc;
	
	//户口地区
	private String hkdq;
	
	//户口地区名称
	private String hkdqmc;
	
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
	
	//婚姻状况名称
	private String hyzkmc;
	
	//家庭电话
	private String jtdh;
	
	//办公电话
	private String bgdh;
	
	//移动电话
	private String yddh;
	
	//电子信箱
	private String dzxx;
	
	//家庭地址
	private String jtdz;
	
	//家庭地址邮编
	private String jtdzyb;
	
	//最高学历代码
	private String zgxldm;
	
	//最高学历名称
	private String zgxlmc;
	
	//最高学位代码
	private String zgxwdm;
	
	//最高学位名称
	private String zgxwmc;
	
	//毕业学校
	private String byxx;
	
	//毕业专业
	private String byzy;
	
	//最终职称代码
	private byte[] zzzcdm;
	
	//最终职称名称
	private String zzzcmc;
	
	//拼音快速索引
	private String pykssy;
	
	//曾用名
	private String zym;
	
	//参加党派时间
	private Date cjdpsj;
	
	//计划生育状况
	private String jhsyzk;
	
	//计划生育状况
	private String jhsyzkmc;
	
	//一卡通唯一码
	private String cardid;
	
	//国籍/地区
	private String gjdqdm;
	
	//
	private String gjdqmc;
	
	//姓名拼音
	private String xmpy;
	
	//
	private Byte deltag;
	
	//
	private String remark;
	
	//照片
	private String photo;
	
	//-1 不通过 ，0 待审核，1 通过
	private Integer audit_status;
	
	//审核人
	private String auditor;
	
	//
	private Date audit_time;
	
	//
	private String xyjgId;
	
	//
	private Date create_time;
	
	//
	private Date update_time;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getApptoken() {
		return apptoken;
	}

	public void setApptoken(String apptoken) {
		this.apptoken = apptoken;
	}
	
	public String getRybh() {
		return rybh;
	}

	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	
	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}
	
	public Long getXb() {
		return xb;
	}

	public void setXb(Long xb) {
		this.xb = xb;
	}
	
	public Long getZjlx() {
		return zjlx;
	}

	public void setZjlx(Long zjlx) {
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
	
	public String getHklbdm() {
		return hklbdm;
	}

	public void setHklbdm(String hklbdm) {
		this.hklbdm = hklbdm;
	}
	
	public String getHklbmc() {
		return hklbmc;
	}

	public void setHklbmc(String hklbmc) {
		this.hklbmc = hklbmc;
	}
	
	public String getHkdq() {
		return hkdq;
	}

	public void setHkdq(String hkdq) {
		this.hkdq = hkdq;
	}
	
	public String getHkdqmc() {
		return hkdqmc;
	}

	public void setHkdqmc(String hkdqmc) {
		this.hkdqmc = hkdqmc;
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
	
	public String getHyzkmc() {
		return hyzkmc;
	}

	public void setHyzkmc(String hyzkmc) {
		this.hyzkmc = hyzkmc;
	}
	
	public String getJtdh() {
		return jtdh;
	}

	public void setJtdh(String jtdh) {
		this.jtdh = jtdh;
	}
	
	public String getBgdh() {
		return bgdh;
	}

	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	
	public String getYddh() {
		return yddh;
	}

	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	
	public String getDzxx() {
		return dzxx;
	}

	public void setDzxx(String dzxx) {
		this.dzxx = dzxx;
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
	
	public String getZgxldm() {
		return zgxldm;
	}

	public void setZgxldm(String zgxldm) {
		this.zgxldm = zgxldm;
	}
	
	public String getZgxlmc() {
		return zgxlmc;
	}

	public void setZgxlmc(String zgxlmc) {
		this.zgxlmc = zgxlmc;
	}
	
	public String getZgxwdm() {
		return zgxwdm;
	}

	public void setZgxwdm(String zgxwdm) {
		this.zgxwdm = zgxwdm;
	}
	
	public String getZgxwmc() {
		return zgxwmc;
	}

	public void setZgxwmc(String zgxwmc) {
		this.zgxwmc = zgxwmc;
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
	
	public byte[] getZzzcdm() {
		return zzzcdm;
	}

	public void setZzzcdm(byte[] zzzcdm) {
		this.zzzcdm = zzzcdm;
	}
	
	public String getZzzcmc() {
		return zzzcmc;
	}

	public void setZzzcmc(String zzzcmc) {
		this.zzzcmc = zzzcmc;
	}
	
	public String getPykssy() {
		return pykssy;
	}

	public void setPykssy(String pykssy) {
		this.pykssy = pykssy;
	}
	
	public String getZym() {
		return zym;
	}

	public void setZym(String zym) {
		this.zym = zym;
	}
	
	public Date getCjdpsj() {
		return cjdpsj;
	}

	public void setCjdpsj(Date cjdpsj) {
		this.cjdpsj = cjdpsj;
	}
	
	public String getJhsyzk() {
		return jhsyzk;
	}

	public void setJhsyzk(String jhsyzk) {
		this.jhsyzk = jhsyzk;
	}
	
	public String getJhsyzkmc() {
		return jhsyzkmc;
	}

	public void setJhsyzkmc(String jhsyzkmc) {
		this.jhsyzkmc = jhsyzkmc;
	}
	
	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	
	public String getGjdqdm() {
		return gjdqdm;
	}

	public void setGjdqdm(String gjdqdm) {
		this.gjdqdm = gjdqdm;
	}
	
	public String getGjdqmc() {
		return gjdqmc;
	}

	public void setGjdqmc(String gjdqmc) {
		this.gjdqmc = gjdqmc;
	}
	
	public String getXmpy() {
		return xmpy;
	}

	public void setXmpy(String xmpy) {
		this.xmpy = xmpy;
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
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Integer getAudit_status() {
		return audit_status;
	}

	public void setAudit_status(Integer audit_status) {
		this.audit_status = audit_status;
	}
	
	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	
	public Date getAudit_time() {
		return audit_time;
	}

	public void setAudit_time(Date audit_time) {
		this.audit_time = audit_time;
	}
	
	public String getXyjgId() {
		return xyjgId;
	}

	public void setXyjgId(String xyjgId) {
		this.xyjgId = xyjgId;
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
	

}
