package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 学年学期设置
 *
 */
public class Xnxqsz implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//学年
	private String xn;
	
	//学期
	private Byte xq;
	
	//开学时间
	private Date kxsj;
	
	//结束时间
	private Date jssj;
	
	//周数
	private Byte zs;
	
	//新生报到时间
	private Date xsbdsj;
	
	//正常课教学日程安排开放开始时间
	private Date zckjxrcapkfkssj;
	
	//正常课教学日程安排开放结束时间
	private Date zckjxrcapkfjssj;
	
	//成绩登分开始时间
	private Date cjlrkssj;
	
	//成绩登分结束时间
	private Date cjlrjssj;
	
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
	
	public String getXn() {
		return xn;
	}

	public void setXn(String xn) {
		this.xn = xn;
	}
	
	public Byte getXq() {
		return xq;
	}

	public void setXq(Byte xq) {
		this.xq = xq;
	}
	
	public Date getKxsj() {
		return kxsj;
	}

	public void setKxsj(Date kxsj) {
		this.kxsj = kxsj;
	}
	
	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}
	
	public Byte getZs() {
		return zs;
	}

	public void setZs(Byte zs) {
		this.zs = zs;
	}
	
	public Date getXsbdsj() {
		return xsbdsj;
	}

	public void setXsbdsj(Date xsbdsj) {
		this.xsbdsj = xsbdsj;
	}
	
	public Date getZckjxrcapkfkssj() {
		return zckjxrcapkfkssj;
	}

	public void setZckjxrcapkfkssj(Date zckjxrcapkfkssj) {
		this.zckjxrcapkfkssj = zckjxrcapkfkssj;
	}
	
	public Date getZckjxrcapkfjssj() {
		return zckjxrcapkfjssj;
	}

	public void setZckjxrcapkfjssj(Date zckjxrcapkfjssj) {
		this.zckjxrcapkfjssj = zckjxrcapkfjssj;
	}
	
	public Date getCjlrkssj() {
		return cjlrkssj;
	}

	public void setCjlrkssj(Date cjlrkssj) {
		this.cjlrkssj = cjlrkssj;
	}
	
	public Date getCjlrjssj() {
		return cjlrjssj;
	}

	public void setCjlrjssj(Date cjlrjssj) {
		this.cjlrjssj = cjlrjssj;
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
