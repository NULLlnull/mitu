package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Kcxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IKcxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Kcxx kcxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Kcxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Kcxx kcxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Kcxx kcxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Kcxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;

}

