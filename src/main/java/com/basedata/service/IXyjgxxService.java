package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Xsxx;
import com.basedata.model.Xyjgxx;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IXyjgxxService {

	/**
	 * 列表
	 *
	 */
	public PageView query(PageView pageView, Xyjgxx xyjgxx, DataTables dataTables, HttpServletRequest request);

	/**
	 * 查询所有组织机构
	 *
	 * @return
	 */
	List<Xyjgxx> findAll(Xyjgxx xyjgxx);

	/**
	 * 详情
	 * 
	 */
	public Xyjgxx getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Xyjgxx xyjgxx, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Xyjgxx xyjgxx, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Xyjgxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

