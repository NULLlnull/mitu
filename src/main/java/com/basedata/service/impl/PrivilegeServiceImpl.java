package com.basedata.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.basedata.dao.IMenuDao;
import com.basedata.dao.IPrivilegeDao;
import com.basedata.model.Menu;
import com.basedata.model.Privilege;
import com.basedata.service.IPrivilegeService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Autowired
	private IPrivilegeDao privilegeDao;

	@Autowired
	private IMenuDao menuDao;

	/**
	 * 列表
	 */
	@Override
	public PageView query(PageView pageView, Privilege privilege, DataTables dataTables, HttpServletRequest request) {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			// subSql.append(" and xxxId =
			// ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition", dataTables.getSearch());
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Privilege> list = privilegeDao.query(pageView, privilege, params);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 详情
	 */
	@Override
	public Privilege getById(String id) {
		try {
			return privilegeDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 更新
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result update(Privilege privilege, Result result) {
		try {
			privilegeDao.update(privilege);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 添加
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result save(Privilege privilege, Result result) {
		try {
			privilegeDao.save(privilege);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 删除
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result delByIds(List<Integer> ids, Result result) {
		try {
			privilegeDao.deleteByPrimaryKeys(ids);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 赋权
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result addPrivilege(String[] children, String[] parents, String roleId, HttpServletRequest request,
			Result result) {
		try {
			// 删除历史记录
			privilegeDao.deleteByRoleId(roleId);
			// 创建新的关系
			if (parents != null && children != null) {
				for (String menuId : parents) {
					Privilege privilege = new Privilege();
					privilege.setMenuId(menuId);
					privilege.setRoleId(roleId);
					privilege.setType(1);
					privilegeDao.save(privilege);
				}
				for (String menuId : children) {
					Privilege privilege = new Privilege();
					privilege.setMenuId(menuId);
					privilege.setRoleId(roleId);
					privilege.setAddFlag(
							StringUtils.isNotBlank(request.getParameter("addFlag" + menuId)) ? "true" : "false");
					privilege.setDeleteFlag(
							StringUtils.isNotBlank(request.getParameter("deleteFlag" + menuId)) ? "true" : "false");
					privilege.setUpdateFlag(
							StringUtils.isNotBlank(request.getParameter("updateFlag" + menuId)) ? "true" : "false");
					privilege.setSelectFlag(
							StringUtils.isNotBlank(request.getParameter("selectFlag" + menuId)) ? "true" : "false");
					privilege.setType(2);
					privilegeDao.save(privilege);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 角色权限
	 */
	@Override
	public Result getPrivilegeByRoleId(Result result, String roleId) {
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("subSql", "roleId = '" + roleId + "'");
			List<Privilege> list = privilegeDao.query(params);
			result.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 角色菜单
	 */
	@Override
	public Result getMenusByRoleId(Result result, String roleId, String sysId) {
		try {
			HashMap<String, String> priParams = new HashMap<String, String>();
			priParams.put("subSql", "roleId = '" + roleId + "'");
			List<Privilege> list = privilegeDao.query(priParams);
			if (list != null && list.size() > 0) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < list.size(); i++) {
					if (i == 0) {
						sb.append("(");
					}
					if (i != list.size() - 1) {
						sb.append(list.get(i).getMenuId()).append(",");
					} else {
						sb.append(list.get(i).getMenuId()).append(")");
					}
				}
				String subSql = "id in " + sb.toString() + " and sysId = '" + sysId + "'";
				HashMap<String, String> menuParams = new HashMap<String, String>();
				menuParams.put("subSql", subSql);
				List<Menu> menus = menuDao.query(menuParams);
				if (menus != null && menus.size() > 0) {
					result.setData(menus);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

}
