package com.basedata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.basedata.model.RyjcxxAudit;
import com.basedata.service.IRyjcxxAuditService;
import com.basedata.vo.DataTables;
import com.basedata.vo.Result;

/**
 * 教师审核
 * 
 * @author Administrator
 *
 */
@RequestMapping("/ryjcxxaudit")
@Controller
public class RyjcxxAuditController extends BaseController<RyjcxxAudit> {

	@Autowired
	private IRyjcxxAuditService ryjcxxAuditService;

	/**
	 * 导出数据
	 * 
	 * @param model
	 * @param ryjcxxAudit
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "exportData.do")
	@ResponseBody
	public List<RyjcxxAudit> exportData(ModelMap model, RyjcxxAudit ryjcxxAudit) throws Exception {
		DataTables dataTables = DataTables.getInstance(request, null);
		List<RyjcxxAudit> data = ryjcxxAuditService.exportData(ryjcxxAudit, dataTables, request);
		return data;
	}

	/**
	 * 添加记录
	 * 
	 * @param model
	 * @param ryjcxxAudit
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
	public String add(ModelMap model, RyjcxxAudit ryjcxxAudit) {
		Result result = new Result();
		result = ryjcxxAuditService.save(ryjcxxAudit, result);
		return JSONObject.toJSONString(result);
	}

}
