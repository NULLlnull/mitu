package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Zypyjh;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IZypyjhService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Zypyjh zypyjh, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Zypyjh getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Zypyjh zypyjh, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Zypyjh zypyjh, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Zypyjh> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;

}

