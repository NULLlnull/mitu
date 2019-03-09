package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Jysxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IJysxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Jysxx jysxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Jysxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Jysxx jysxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Jysxx jysxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Jysxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

