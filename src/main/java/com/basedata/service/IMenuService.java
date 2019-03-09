package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Menu;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IMenuService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Menu menu, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Menu getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Menu menu, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Menu menu, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Menu> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;

	/**
	 * 展示的菜单
	 */
	public List<Menu> findByStatus(int i);

}
