package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.RyjcxxAudit;
import com.basedata.vo.DataTables;
import com.basedata.vo.Result;

public interface IRyjcxxAuditService {

	/**
	 * 添加记录
	 * 
	 * @param ryjcxxAudit
	 * @param result
	 * @return
	 */
	public Result save(RyjcxxAudit ryjcxxAudit, Result result);

	/**
	 * 导出数据
	 * 
	 * @param ryjcxxAudit
	 * @param dataTables
	 * @param request
	 * @return
	 */
	public List<RyjcxxAudit> exportData(RyjcxxAudit ryjcxxAudit, DataTables dataTables, HttpServletRequest request);

}
