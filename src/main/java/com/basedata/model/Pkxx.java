package com.basedata.model;

/**
 * 排课信息实体
 *
 */
public class Pkxx {
	private int id;
	// 教学任务ID
	private int jxrwid;
	// 星期
	private int xqs;
	// 节次
	private int jc;
	// 授课场地代码
	private String skcddm;
	// 授课场地名称
	private String skcdmc;
	// 授课教师
	private String skjs;
	// 授课教师姓名
	private String skjsxm;
	// 单双周设置 0无/1单/2双
	private int dszsz;
	// 排课周次
	private String pkzc;
	private String pkzcshow;
	private String remark;
	private int create_time;
	private int update_time;
	private int deltag;
	private String oprybh;
	private int sdzt;
	private int btbpk;
	private String tbpkcyjxrwid;
	// 同步排课成员(合班情况)
	private String tbpkcy;
	// 管理员锁定
	private int glsd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJxrwid() {
		return jxrwid;
	}

	public void setJxrwid(int jxrwid) {
		this.jxrwid = jxrwid;
	}

	public int getXqs() {
		return xqs;
	}

	public void setXqs(int xqs) {
		this.xqs = xqs;
	}

	public int getJc() {
		return jc;
	}

	public void setJc(int jc) {
		this.jc = jc;
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

	public String getSkjs() {
		return skjs;
	}

	public void setSkjs(String skjs) {
		this.skjs = skjs;
	}

	public String getSkjsxm() {
		return skjsxm;
	}

	public void setSkjsxm(String skjsxm) {
		this.skjsxm = skjsxm;
	}

	public int getDszsz() {
		return dszsz;
	}

	public void setDszsz(int dszsz) {
		this.dszsz = dszsz;
	}

	public String getPkzc() {
		return pkzc;
	}

	public void setPkzc(String pkzc) {
		this.pkzc = pkzc;
	}

	public String getPkzcshow() {
		return pkzcshow;
	}

	public void setPkzcshow(String pkzcshow) {
		this.pkzcshow = pkzcshow;
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

	public String getOprybh() {
		return oprybh;
	}

	public void setOprybh(String oprybh) {
		this.oprybh = oprybh;
	}

	public int getSdzt() {
		return sdzt;
	}

	public void setSdzt(int sdzt) {
		this.sdzt = sdzt;
	}

	public int getBtbpk() {
		return btbpk;
	}

	public void setBtbpk(int btbpk) {
		this.btbpk = btbpk;
	}

	public String getTbpkcyjxrwid() {
		return tbpkcyjxrwid;
	}

	public void setTbpkcyjxrwid(String tbpkcyjxrwid) {
		this.tbpkcyjxrwid = tbpkcyjxrwid;
	}

	public String getTbpkcy() {
		return tbpkcy;
	}

	public void setTbpkcy(String tbpkcy) {
		this.tbpkcy = tbpkcy;
	}

	public int getGlsd() {
		return glsd;
	}

	public void setGlsd(int glsd) {
		this.glsd = glsd;
	}

}
