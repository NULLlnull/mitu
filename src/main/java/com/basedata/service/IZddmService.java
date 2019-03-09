package com.basedata.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Zddm;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IZddmService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Zddm zddm, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Zddm getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Zddm zddm, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Zddm zddm, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出数据
	 *
	 * @param dataTables
	 * @param request
	 * @return
	 */
	public List<Zddm> exportData(DataTables dataTables, HttpServletRequest request);

	/**
	 * 获取字典类别数据
	 *
	 * @param zdlbs
	 * @return
	 * @throws Exception
	 */
	public Result property(String zdlbs);


}

