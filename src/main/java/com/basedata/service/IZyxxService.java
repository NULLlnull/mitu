package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Zyxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IZyxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Zyxx zyxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Zyxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Zyxx zyxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Zyxx zyxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Zyxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

