package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Jssysxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IJssysxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Jssysxx jssysxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Jssysxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Jssysxx jssysxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Jssysxx jssysxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Jssysxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

