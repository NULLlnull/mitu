package com.basedata.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 */
public class RyjcxxAudit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	
	//
	private String teacherId;
	
	//-1 不通过 ，0 待审核，1 通过
	private Integer audit_status;
	
	//审核人
	private String auditor;
	
	//
	private String audit_opinion;
	
	//
	private Date audit_time;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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
	
	public String getAudit_opinion() {
		return audit_opinion;
	}

	public void setAudit_opinion(String audit_opinion) {
		this.audit_opinion = audit_opinion;
	}
	
	public Date getAudit_time() {
		return audit_time;
	}

	public void setAudit_time(Date audit_time) {
		this.audit_time = audit_time;
	}
	

}
