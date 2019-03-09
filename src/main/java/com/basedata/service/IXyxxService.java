package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Xyxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IXyxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Xyxx xyxx);

	/**
	 * 详情
	 * 
	 */
	public Xyxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Xyxx xyxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Xyxx xyxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Xyxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

