package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Zypyjhzb;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IZypyjhzbService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Zypyjhzb zypyjhzb, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Zypyjhzb getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Zypyjhzb zypyjhzb, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Zypyjhzb zypyjhzb, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Zypyjhzb> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;

	/**
	 * 根据教师Id获取
	 */
	public List<Zypyjhzb> getByTeacherId(String teacherId);

}

