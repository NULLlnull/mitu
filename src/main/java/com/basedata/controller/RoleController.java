package com.basedata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedLogin;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Menu;
import com.basedata.model.Role;
import com.basedata.service.IMenuService;
import com.basedata.service.IPrivilegeService;
import com.basedata.service.IRoleService;
import com.basedata.vo.DataTables;
import com.basedata.vo.DataUtils;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;
import com.basedata.vo.SystemContext;

/**
 * Role
 */
@RequestMapping("/role")
@Controller
public class RoleController extends BaseController<Role> {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IPrivilegeService privilegeService;

	/**
	 * 列表
	 */
	@NeedPage
	@ResponseBody
	@RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
	public String list(ModelMap model, Role role) {
		DataTables dataTables = DataTables.getInstance(request, null);
		PageView pageView = new PageView(SystemContext.getOffset());
		roleService.query(pageView, role, dataTables, request);
		return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
	}

	/**
	 * 详情
	 */
	@NeedLogin
	@ResponseBody
	@RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
	public String edit(ModelMap model, String id) {
		return JSONObject.toJSONString(roleService.getById(id));
	}

	/**
	 * 更新
	 */
	@NeedLogin
	@ResponseBody
	@RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
	public String update(Role role) {
		Result result = new Result();
		result = roleService.update(role, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 添加
	 */
	@NeedLogin
	@ResponseBody
	@RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
	public String add(Role role) {
		Result result = new Result();
		result = roleService.save(role, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 删除
	 */
	@NeedLogin
	@ResponseBody
	@RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
	public String del(@RequestParam("ids[]") List<Integer> ids) {
		Result result = new Result();
		result = roleService.delByIds(ids, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 授权页面
	 */
	@NeedLogin
	@RequestMapping(value = "permit.do")
	public String permit(ModelMap model, String roleId) {
		List<Menu> parentMenu = new ArrayList<Menu>();
		List<Menu> childMenu = new ArrayList<Menu>();
		List<Menu> menuList = menuService.findByStatus(0);
		for (int i = 0; i < menuList.size(); i++) {
			Menu menu = menuList.get(i);
			if (menu.getParentId() == -1) {
				parentMenu.add(menu);
			} else {
				childMenu.add(menu);
			}
		}
		model.addAttribute("roleId", roleId);
		model.addAttribute("parentMenu", parentMenu);
		model.addAttribute("childMenu", childMenu);
		return "role/permit";
	}

	/**
	 * 授权
	 */
	@NeedLogin
	@ResponseBody
	@RequestMapping(value = "addPrivilege.do", produces = { "application/json;charset=utf-8" })
	public Result addPrivilege(String[] children, String[] parents, String roleId) {
		Result result = new Result(0);
		result = privilegeService.addPrivilege(children, parents, roleId, request, result);
		return result;
	}

	/**
	 * 角色授权
	 */
	@ResponseBody
	@RequestMapping(value = "getPrivilegeByRoleId.do", produces = { "application/json;charset=utf-8" })
	public Result getPrivilegeByRoleId(String roleId) {
		Result result = new Result(0);
		result = privilegeService.getPrivilegeByRoleId(result, roleId);
		return result;
	}

	/**
	 * 角色菜单
	 */
	@ResponseBody
	@RequestMapping(value = "getMenusByRoleId.do", produces = { "application/json;charset=utf-8" })
	public Result getMenusByRoleId(String roleId, String sysId) {
		Result result = new Result(0);
		result = privilegeService.getMenusByRoleId(result, roleId, sysId);
		return result;
	}

}
