package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Menu;
import com.basedata.model.User;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IUserService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, User user, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public User getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(User user, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(User user, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<User> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;

	/**
	 * 用户登录
	 */
	public Result login(String username, String password);

	/**
	 * 本地用户登录
	 */
	public Result userLogin(HttpServletRequest request, String username, String password);

	/**
	 * 用户菜单
	 */
	public List<Menu> getMenus(User user, HttpServletRequest request);

}
