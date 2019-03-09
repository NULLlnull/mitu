package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Zdlb;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IZdlbService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Zdlb zdlb, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Zdlb getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Zdlb zdlb, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Zdlb zdlb, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Zdlb> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

