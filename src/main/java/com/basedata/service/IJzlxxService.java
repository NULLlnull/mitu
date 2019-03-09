package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Jzlxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IJzlxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Jzlxx jzlxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Jzlxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Jzlxx jzlxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Jzlxx jzlxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Jzlxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

