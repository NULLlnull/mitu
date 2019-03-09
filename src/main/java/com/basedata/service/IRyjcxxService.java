package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Ryjcxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IRyjcxxService {

	/**
	 * 教师信息列表页
	 * 
	 * @param pageView
	 * @param ryjcxx
	 * @param dataTables
	 * @param request
	 * @return
	 */
	public PageView query(PageView pageView, Ryjcxx ryjcxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 教师信息详情页
	 * 
	 * @param id
	 * @return
	 */
	public Ryjcxx getById(String id);

	/**
	 * 更新记录
	 * 
	 * @param ryjcxx
	 * @param result
	 * @return
	 */
	public Result update(Ryjcxx ryjcxx, Result result);

	/**
	 * 添加记录
	 * 
	 * @param ryjcxx
	 * @param result
	 * @return
	 */
	public Result save(Ryjcxx ryjcxx, Result result);

	/**
	 * 删除记录
	 * 
	 * @param ids
	 * @param result
	 * @return
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出数据
	 * 
	 * @param dataTables
	 * @param request
	 * @return
	 */
	public List<Ryjcxx> exportData(DataTables dataTables, HttpServletRequest request);

}
