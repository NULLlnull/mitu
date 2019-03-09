package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Zyksnj;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IZyksnjService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Zyksnj zyksnj, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Zyksnj getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Zyksnj zyksnj, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Zyksnj zyksnj, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Zyksnj> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;

	/**
	 * 根据教师Id获取
	 */
	public List<Zyksnj> getByTeacherId(String teacherId);

}

