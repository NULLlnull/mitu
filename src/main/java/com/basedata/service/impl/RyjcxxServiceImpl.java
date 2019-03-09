package com.basedata.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.basedata.dao.IRyjcxxDao;
import com.basedata.model.Ryjcxx;
import com.basedata.service.IRyjcxxService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class RyjcxxServiceImpl implements IRyjcxxService {

	@Autowired
	private IRyjcxxDao ryjcxxDao;

	/**
	 * 教师信息列表页
	 */
	@Override
	public PageView query(PageView pageView, Ryjcxx ryjcxx, DataTables dataTables, HttpServletRequest request) {
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("condition", dataTables.getSearch());
			if (StringUtils.isNotBlank(request.getParameter("xyjgId"))) {
				params.put("subSql", "xyjgId = " + request.getParameter("xyjgId"));
			}
			List<Ryjcxx> list = ryjcxxDao.query(pageView, ryjcxx, params);
			pageView.setRecords(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageView;
	}

	/**
	 * 教师信息详情页
	 */
	@Override
	public Ryjcxx getById(String id) {
		return ryjcxxDao.getById(id);
	}

	/**
	 * 更新记录
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result update(Ryjcxx ryjcxx, Result result) {
		try {
			ryjcxxDao.update(ryjcxx);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 添加记录
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result save(Ryjcxx ryjcxx, Result result) {
		try {
			ryjcxxDao.save(ryjcxx);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(-1);
		}
		return result;
	}

	/**
	 * 删除记录
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Result delByIds(List<Integer> ids, Result result) {
		try {
			ryjcxxDao.deleteByPrimaryKeys(ids);
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
	public List<Ryjcxx> exportData(DataTables dataTables, HttpServletRequest request) {
		List<Ryjcxx> list = new ArrayList<Ryjcxx>();
		try {
			HashMap<String, String> params = new HashMap<String, String>();
			params.put("condition", dataTables.getSearch());
			if (StringUtils.isNotBlank(request.getParameter("xyjgId"))) {
				params.put("subSql", "xyjgId = " + request.getParameter("xyjgId"));
			}
			list = ryjcxxDao.query(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
