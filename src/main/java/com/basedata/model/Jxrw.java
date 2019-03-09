package com.basedata.model;

import java.math.BigDecimal;

/**
 * 教学任务实体
 *
 */
public class Jxrw {
	private int id;
	// 所属计划
	private int ssjh;
	// 所属选课
	private int ssxk;
	// 所属合班
	private int sshb;
	// 学年
	private String xn;
	// 学期
	private int xq;
	// 任务类型(理论/实践)
	private String rwlx;
	// 课程ID
	private String kcdm;
	// 课程名称
	private String kcmc;
	// 课程性质(必修01/限选02/任选03)
	private String kcxz;
	// 主干课程
	private int zgkc;
	// 考核方式
	private String khfs;
	// 学期总学时
	private BigDecimal xqzxs;
	// 讲课学时
	private BigDecimal jkxs;
	// 实验学时
	private BigDecimal syxs;
	// 上机学时
	private BigDecimal sjxs;
	// 周学时
	private BigDecimal zxs;
	// 周学时排课信息
	private BigDecimal zxspkxx;
	// 周数
	private int zs;
	// 周数排课信息
	private int zspkxx;
	// 课程学分
	private BigDecimal kcxf;
	// 所属学院
	private String ssxy;
	// 所属系部
	private String ssxb;
	// 所属系部名称
	private String ssxbmc;
	// 所属教研室
	private String ssjys;
	// 所属教研室名称
	private String ssjysmc;
	private String remark;
	private int create_time;
	private int update_time;
	private int deltag;
	// 主导教师
	private String zdjs;
	// 主导教师姓名
	private String zdjsxm;
	// 其它辅导教师(姓名,)
	private String qtfdjsxm;
	// 其它辅导教师(工号,)
	private String qtfdjs;
	// 所属班级
	private String ssbj;
	// 班级名称
	private String bjmc;
	// 任务类型状态(正常课/合班/选课)
	private String rwlxzt;
	// 任务执行状态
	private int zxzt;
	// 课代表(学生)
	private String kdb;
	// 科代表姓名
	private String kdbxm;
	// 科代表辅助考勤开放
	private int kdbfzkqkf;
	// 是否考核
	private int sfkh;
	// 成绩评定类型
	private String cjptlx;
	// 成绩提交标志
	private int cjtjbz;
	// 教材选用标志(0无操作 1已选用 2无需选用)
	private int jcxybz;
	// 操作人员
	private String oprybh;
	// 授课场地代码
	private String skcddm;
	// 授课场地名称
	private String skcdmc;
	// 开始周
	private int ksz;
	// 结束周
	private int jsz;
	// 排课信息
	private String pkxx;
	// 教学周次
	private String jxzc;
	// 排课周次
	private String pkcz;
	// 学生学习本课程必备的知识和技能
	private String bbzsjn;
	// 本课程为后续课程提供的知识
	private String hxkctgzs;
	// 本课程为后续课程提供的技能
	private String hxkctgjn;
	// 教学大纲名称、版本
	private String kcjxdgxx;
	// 知识目标
	private String kcjyzsmb;
	// 能力目标
	private String kcjynlmb;
	// 本课程的考核办法
	private String kckhbf;
	// 结对子教师
	private String jdzjs;
	// 结对子教师课时
	private BigDecimal jdzjsks;
	// 工作量系数
	private BigDecimal gzlxs;
	// 已认定学时
	private BigDecimal yrdxs;
	// 授课计划审核
	private int skjhsh;
	// 测评应测学生数
	private int cpycrs;
	// 测评实测学生数
	private int cpscrs;
	// 学生测评评均分
	private BigDecimal cppjf;
	// 测评有效人数
	private int cpyxrs;
	// 测评评估得分
	private BigDecimal cppgdf;
	// 成绩提交按钮
	private int cjtjan;
	// 授课计划提交
	private int skjhtjan;
	// 排课状态1已排0未排或已排结束s
	private int pkzt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSsjh() {
		return ssjh;
	}

	public void setSsjh(int ssjh) {
		this.ssjh = ssjh;
	}

	public int getSsxk() {
		return ssxk;
	}

	public void setSsxk(int ssxk) {
		this.ssxk = ssxk;
	}

	public int getSshb() {
		return sshb;
	}

	public void setSshb(int sshb) {
		this.sshb = sshb;
	}

	public String getXn() {
		return xn;
	}

	public void setXn(String xn) {
		this.xn = xn;
	}

	public int getXq() {
		return xq;
	}

	public void setXq(int xq) {
		this.xq = xq;
	}

	public String getRwlx() {
		return rwlx;
	}

	public void setRwlx(String rwlx) {
		this.rwlx = rwlx;
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

	public String getKcxz() {
		return kcxz;
	}

	public void setKcxz(String kcxz) {
		this.kcxz = kcxz;
	}

	public int getZgkc() {
		return zgkc;
	}

	public void setZgkc(int zgkc) {
		this.zgkc = zgkc;
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

	public BigDecimal getZxspkxx() {
		return zxspkxx;
	}

	public void setZxspkxx(BigDecimal zxspkxx) {
		this.zxspkxx = zxspkxx;
	}

	public int getZs() {
		return zs;
	}

	public void setZs(int zs) {
		this.zs = zs;
	}

	public int getZspkxx() {
		return zspkxx;
	}

	public void setZspkxx(int zspkxx) {
		this.zspkxx = zspkxx;
	}

	public BigDecimal getKcxf() {
		return kcxf;
	}

	public void setKcxf(BigDecimal kcxf) {
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

	public int getCreate_time() {
		return create_time;
	}

	public void setCreate_time(int create_time) {
		this.create_time = create_time;
	}

	public int getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(int update_time) {
		this.update_time = update_time;
	}

	public int getDeltag() {
		return deltag;
	}

	public void setDeltag(int deltag) {
		this.deltag = deltag;
	}

	public String getZdjs() {
		return zdjs;
	}

	public void setZdjs(String zdjs) {
		this.zdjs = zdjs;
	}

	public String getZdjsxm() {
		return zdjsxm;
	}

	public void setZdjsxm(String zdjsxm) {
		this.zdjsxm = zdjsxm;
	}

	public String getQtfdjsxm() {
		return qtfdjsxm;
	}

	public void setQtfdjsxm(String qtfdjsxm) {
		this.qtfdjsxm = qtfdjsxm;
	}

	public String getQtfdjs() {
		return qtfdjs;
	}

	public void setQtfdjs(String qtfdjs) {
		this.qtfdjs = qtfdjs;
	}

	public String getSsbj() {
		return ssbj;
	}

	public void setSsbj(String ssbj) {
		this.ssbj = ssbj;
	}

	public String getBjmc() {
		return bjmc;
	}

	public void setBjmc(String bjmc) {
		this.bjmc = bjmc;
	}

	public String getRwlxzt() {
		return rwlxzt;
	}

	public void setRwlxzt(String rwlxzt) {
		this.rwlxzt = rwlxzt;
	}

	public int getZxzt() {
		return zxzt;
	}

	public void setZxzt(int zxzt) {
		this.zxzt = zxzt;
	}

	public String getKdb() {
		return kdb;
	}

	public void setKdb(String kdb) {
		this.kdb = kdb;
	}

	public String getKdbxm() {
		return kdbxm;
	}

	public void setKdbxm(String kdbxm) {
		this.kdbxm = kdbxm;
	}

	public int getKdbfzkqkf() {
		return kdbfzkqkf;
	}

	public void setKdbfzkqkf(int kdbfzkqkf) {
		this.kdbfzkqkf = kdbfzkqkf;
	}

	public int getSfkh() {
		return sfkh;
	}

	public void setSfkh(int sfkh) {
		this.sfkh = sfkh;
	}

	public String getCjptlx() {
		return cjptlx;
	}

	public void setCjptlx(String cjptlx) {
		this.cjptlx = cjptlx;
	}

	public int getCjtjbz() {
		return cjtjbz;
	}

	public void setCjtjbz(int cjtjbz) {
		this.cjtjbz = cjtjbz;
	}

	public int getJcxybz() {
		return jcxybz;
	}

	public void setJcxybz(int jcxybz) {
		this.jcxybz = jcxybz;
	}

	public String getOprybh() {
		return oprybh;
	}

	public void setOprybh(String oprybh) {
		this.oprybh = oprybh;
	}

	public String getSkcddm() {
		return skcddm;
	}

	public void setSkcddm(String skcddm) {
		this.skcddm = skcddm;
	}

	public String getSkcdmc() {
		return skcdmc;
	}

	public void setSkcdmc(String skcdmc) {
		this.skcdmc = skcdmc;
	}

	public int getKsz() {
		return ksz;
	}

	public void setKsz(int ksz) {
		this.ksz = ksz;
	}

	public int getJsz() {
		return jsz;
	}

	public void setJsz(int jsz) {
		this.jsz = jsz;
	}

	public String getPkxx() {
		return pkxx;
	}

	public void setPkxx(String pkxx) {
		this.pkxx = pkxx;
	}

	public String getJxzc() {
		return jxzc;
	}

	public void setJxzc(String jxzc) {
		this.jxzc = jxzc;
	}

	public String getPkcz() {
		return pkcz;
	}

	public void setPkcz(String pkcz) {
		this.pkcz = pkcz;
	}

	public String getBbzsjn() {
		return bbzsjn;
	}

	public void setBbzsjn(String bbzsjn) {
		this.bbzsjn = bbzsjn;
	}

	public String getHxkctgzs() {
		return hxkctgzs;
	}

	public void setHxkctgzs(String hxkctgzs) {
		this.hxkctgzs = hxkctgzs;
	}

	public String getHxkctgjn() {
		return hxkctgjn;
	}

	public void setHxkctgjn(String hxkctgjn) {
		this.hxkctgjn = hxkctgjn;
	}

	public String getKcjxdgxx() {
		return kcjxdgxx;
	}

	public void setKcjxdgxx(String kcjxdgxx) {
		this.kcjxdgxx = kcjxdgxx;
	}

	public String getKcjyzsmb() {
		return kcjyzsmb;
	}

	public void setKcjyzsmb(String kcjyzsmb) {
		this.kcjyzsmb = kcjyzsmb;
	}

	public String getKcjynlmb() {
		return kcjynlmb;
	}

	public void setKcjynlmb(String kcjynlmb) {
		this.kcjynlmb = kcjynlmb;
	}

	public String getKckhbf() {
		return kckhbf;
	}

	public void setKckhbf(String kckhbf) {
		this.kckhbf = kckhbf;
	}

	public String getJdzjs() {
		return jdzjs;
	}

	public void setJdzjs(String jdzjs) {
		this.jdzjs = jdzjs;
	}

	public BigDecimal getJdzjsks() {
		return jdzjsks;
	}

	public void setJdzjsks(BigDecimal jdzjsks) {
		this.jdzjsks = jdzjsks;
	}

	public BigDecimal getGzlxs() {
		return gzlxs;
	}

	public void setGzlxs(BigDecimal gzlxs) {
		this.gzlxs = gzlxs;
	}

	public BigDecimal getYrdxs() {
		return yrdxs;
	}

	public void setYrdxs(BigDecimal yrdxs) {
		this.yrdxs = yrdxs;
	}

	public int getSkjhsh() {
		return skjhsh;
	}

	public void setSkjhsh(int skjhsh) {
		this.skjhsh = skjhsh;
	}

	public int getCpycrs() {
		return cpycrs;
	}

	public void setCpycrs(int cpycrs) {
		this.cpycrs = cpycrs;
	}

	public int getCpscrs() {
		return cpscrs;
	}

	public void setCpscrs(int cpscrs) {
		this.cpscrs = cpscrs;
	}

	public BigDecimal getCppjf() {
		return cppjf;
	}

	public void setCppjf(BigDecimal cppjf) {
		this.cppjf = cppjf;
	}

	public int getCpyxrs() {
		return cpyxrs;
	}

	public void setCpyxrs(int cpyxrs) {
		this.cpyxrs = cpyxrs;
	}

	public BigDecimal getCppgdf() {
		return cppgdf;
	}

	public void setCppgdf(BigDecimal cppgdf) {
		this.cppgdf = cppgdf;
	}

	public int getCjtjan() {
		return cjtjan;
	}

	public void setCjtjan(int cjtjan) {
		this.cjtjan = cjtjan;
	}

	public int getSkjhtjan() {
		return skjhtjan;
	}

	public void setSkjhtjan(int skjhtjan) {
		this.skjhtjan = skjhtjan;
	}

	public int getPkzt() {
		return pkzt;
	}

	public void setPkzt(int pkzt) {
		this.pkzt = pkzt;
	}

}
