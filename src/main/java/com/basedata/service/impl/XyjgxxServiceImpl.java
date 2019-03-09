package com.basedata.service.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Xsxx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.basedata.dao.IXyjgxxDao;
import com.basedata.model.Xyjgxx;
import com.basedata.service.IXyjgxxService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class XyjgxxServiceImpl implements IXyjgxxService {

	@Autowired
	private IXyjgxxDao xyjgxxDao;

	/**
	 * 列表
	 */
	@Override
	public PageView query(PageView pageView, Xyjgxx xyjgxx, DataTables dataTables, HttpServletRequest request) {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition", dataTables.getSearch());
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Xyjgxx> list = xyjgxxDao.query(pageView, xyjgxx, params);
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 查询所有组织机构
	 *
	 * @return
	 */
	@Override
	public List<Xyjgxx> findAll(Xyjgxx xyjgxx) {
		return xyjgxxDao.queryAll(xyjgxx);
	}

	/**
	 * 详情
	 */
	@Override
	public Xyjgxx getById(String id) {
		try {
			return xyjgxxDao.getById(id);
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
	public Result update(Xyjgxx xyjgxx, Result result) {
		try {
			xyjgxxDao.update(xyjgxx);
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
	public Result save(Xyjgxx xyjgxx, Result result) {
		try {
			xyjgxxDao.save(xyjgxx);
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
			xyjgxxDao.deleteByPrimaryKeys(ids);
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
	public List<Xyjgxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
		StringBuffer subSql = new StringBuffer(" ");
		if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
			//subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
		}
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("condition",
				URLDecoder.decode(dataTables.getSearch() != null ? dataTables.getSearch() : "", "UTF-8"));
		params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
		List<Xyjgxx> Xyjgxxs = xyjgxxDao.query(params);
		return Xyjgxxs;
	}

}

