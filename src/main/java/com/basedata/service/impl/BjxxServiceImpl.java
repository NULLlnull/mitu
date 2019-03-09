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

import com.basedata.dao.IBjxxDao;
import com.basedata.model.Bjxx;
import com.basedata.service.IBjxxService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class BjxxServiceImpl implements IBjxxService {

	@Autowired
	private IBjxxDao bjxxDao;

	/**
	 * 获取查询条件
	 */
	private HashMap<String, String> getSearchMap(DataTables dataTables, HttpServletRequest request) {
		StringBuffer subSql = new StringBuffer("");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition", dataTables.getSearch());
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		return params;
	}

	/**
	 * 字典转换
	 */
	private List<Bjxx> zddmConvert(List<Bjxx> list) {
		return list;
	}

	/**
	 * 列表
	 */
	@Override
	public PageView query(PageView pageView, Bjxx Bjxx, DataTables dataTables, HttpServletRequest request) {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition", dataTables.getSearch());
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Bjxx> list = bjxxDao.query(pageView, Bjxx, params);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 详情
	 */
	@Override
	public Bjxx getById(String id) {
		try {
			return bjxxDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 列表
	 */
	@Override
	public List<Bjxx> queryAll(Bjxx bjxx) {
		List<Bjxx> list = zddmConvert(bjxxDao.queryAll(bjxx));
		return list;
	}

	/**
	 * 更新
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result update(Bjxx bjxx, Result result) {
		try {
			System.out.println("[bjxxDao]mc=" + bjxx.getBjmc() + ",id=" + bjxx.getId());
			bjxxDao.update(bjxx);
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
	public Result save(Bjxx bjxx, Result result) {
		try {
			bjxxDao.save(bjxx);
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
			bjxxDao.deleteByPrimaryKeys(ids);
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
	public List<Bjxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition",
				URLDecoder.decode(dataTables.getSearch() != null ? dataTables.getSearch() : "", "UTF-8"));
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Bjxx> Bjxxs = bjxxDao.query(params);
		return Bjxxs;
	}

}

