package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Role;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IRoleService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Role role, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Role getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Role role, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Role role, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Role> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

