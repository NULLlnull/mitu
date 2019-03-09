package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedPage;
import com.basedata.model.User;
import com.basedata.service.IUserService;
import com.basedata.vo.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User
 */
@RequestMapping("/user")
@Controller
public class UserController extends BaseController<User> {

	@Autowired
	private IUserService userService;

	/**
	 * 列表
	 */
	@NeedPage
	@ResponseBody
	@RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
	public String list(ModelMap model, User user) {
		DataTables dataTables = DataTables.getInstance(request, null);
		PageView pageView = new PageView(SystemContext.getOffset());
		userService.query(pageView, user, dataTables, request);
		return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
	}

	/**
	 * 详情
	 */
	@ResponseBody
	@RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
	public String edit(ModelMap model, String id) {
		return JSONObject.toJSONString(userService.getById(id));
	}

	/**
	 * 更新
	 */
	@ResponseBody
	@RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
	public String update(User user) {
		Result result = new Result();
		result = userService.update(user, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 添加
	 */
	@ResponseBody
	@RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
	public String add(User user) {
		Result result = new Result();
		result = userService.save(user, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
	public String del(@RequestParam("ids[]") List<Integer> ids) {
		Result result = new Result();
		result = userService.delByIds(ids, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "login.do", produces = "application/json; charset=utf-8")
	public Result login(String username, String password) {
		return userService.login(username, password);
	}

	/**
	 * 本地登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "userLogin.do", produces = "application/json; charset=utf-8")
	public Result userLogin(String username, String password) {
		Result result = new Result();
		if (StringUtils.isAnyBlank(username, password)) {
			result.setStatus(-1);
			return result;
		}
		result = userService.userLogin(request, username, password);
		return result;
	}

}
