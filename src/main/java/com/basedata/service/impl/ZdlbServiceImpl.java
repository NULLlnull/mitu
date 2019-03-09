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

import com.basedata.dao.IZdlbDao;
import com.basedata.model.Zdlb;
import com.basedata.service.IZdlbService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ZdlbServiceImpl implements IZdlbService {

	@Autowired
	private IZdlbDao ZdlbDao;

	/**
	 * 列表
	 */
	@Override
	public PageView query(PageView pageView, Zdlb Zdlb, DataTables dataTables, HttpServletRequest request) {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition", dataTables.getSearch());
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Zdlb> list = ZdlbDao.query(pageView, Zdlb, params);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 详情
	 */
	@Override
	public Zdlb getById(String id) {
		try {
			return ZdlbDao.getById(id);
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
	public Result update(Zdlb zdlb, Result result) {
		try {
			ZdlbDao.update(zdlb);
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
	public Result save(Zdlb zdlb, Result result) {
		try {
			ZdlbDao.save(zdlb);
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
			ZdlbDao.deleteByPrimaryKeys(ids);
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
	public List<Zdlb> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition",
				URLDecoder.decode(dataTables.getSearch() != null ? dataTables.getSearch() : "", "UTF-8"));
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Zdlb> Zdlbs = ZdlbDao.query(params);
		return Zdlbs;
	}

}

