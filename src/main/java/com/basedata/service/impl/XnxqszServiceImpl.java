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

import com.basedata.dao.IXnxqszDao;
import com.basedata.model.Xnxqsz;
import com.basedata.service.IXnxqszService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class XnxqszServiceImpl implements IXnxqszService {

	@Autowired
	private IXnxqszDao XnxqszDao;

	/**
	 * 列表
	 */
	@Override
	public PageView query(PageView pageView, Xnxqsz Xnxqsz, DataTables dataTables, HttpServletRequest request) {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition", dataTables.getSearch());
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Xnxqsz> list = XnxqszDao.query(pageView, Xnxqsz, params);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 详情
	 */
	@Override
	public Xnxqsz getById(String id) {
		try {
			return XnxqszDao.getById(id);
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
	public Result update(Xnxqsz xnxqsz, Result result) {
		try {
			XnxqszDao.update(xnxqsz);
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
	public Result save(Xnxqsz xnxqsz, Result result) {
		try {
			XnxqszDao.save(xnxqsz);
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
			XnxqszDao.deleteByPrimaryKeys(ids);
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
	public List<Xnxqsz> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition",
				URLDecoder.decode(dataTables.getSearch() != null ? dataTables.getSearch() : "", "UTF-8"));
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Xnxqsz> Xnxqszs = XnxqszDao.query(params);
		return Xnxqszs;
	}

}

