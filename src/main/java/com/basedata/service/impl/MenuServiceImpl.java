package com.basedata.service.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.basedata.dao.IMenuDao;
import com.basedata.model.Menu;
import com.basedata.service.IMenuService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;

	/**
	 * 列表
	 */
	@Override
	public PageView query(PageView pageView, Menu Menu, DataTables dataTables, HttpServletRequest request) {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			// subSql.append(" and xxxId =
			// ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition", dataTables.getSearch());
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Menu> list = menuDao.query(pageView, Menu, params);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 详情
	 */
	@Override
	public Menu getById(String id) {
		try {
			return menuDao.getById(id);
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
	public Result update(Menu menu, Result result) {
		try {
			menuDao.update(menu);
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
	public Result save(Menu menu, Result result) {
		try {
			menuDao.save(menu);
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
			menuDao.deleteByPrimaryKeys(ids);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 导出数据
	 */
	@Override
	public List<Menu> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			// subSql.append(" and xxxId =
			// ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition",
				URLDecoder.decode(dataTables.getSearch() != null ? dataTables.getSearch() : "", "UTF-8"));
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Menu> menus = menuDao.query(params);
		return menus;
	}

	/**
	 * 展示的菜单
	 */
	@Override
	public List<Menu> findByStatus(int status) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("subSql", "status = 0");
		List<Menu> menus = menuDao.query(params);
		return menus;
	}

}
