package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Bjxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IBjxxService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Bjxx bjxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Bjxx getById(String id);

	public List<Bjxx> queryAll(Bjxx bjxx) ;
	/**
	 * 更新
	 * 
	 */
	public Result update(Bjxx bjxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Bjxx bjxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Bjxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

