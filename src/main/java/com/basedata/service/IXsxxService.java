package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Xsxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IXsxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Xsxx xsxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Xsxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Xsxx xsxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Xsxx xsxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Xsxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

