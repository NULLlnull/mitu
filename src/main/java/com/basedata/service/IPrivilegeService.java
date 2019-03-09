package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Privilege;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IPrivilegeService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Privilege privilege, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Privilege getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Privilege privilege, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Privilege privilege, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 赋权
	 */
	public Result addPrivilege(String[] children, String[] parents, String roleId, HttpServletRequest request,
                               Result result);

	/**
	 * 角色权限
	 */
	public Result getPrivilegeByRoleId(Result result, String roleId);

	/**
	 * 角色菜单
	 */
	public Result getMenusByRoleId(Result result, String roleId, String sysId);

}
