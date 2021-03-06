package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.model.Xnxqsz;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IXnxqszService {

	/**
	 * 列表
	 * 
	 */
	public PageView query(PageView pageView, Xnxqsz xnxqsz, DataTables dataTables, HttpServletRequest request);

	/**
	 * 详情
	 * 
	 */
	public Xnxqsz getById(String id);

	/**
	 * 更新
	 * 
	 */
	public Result update(Xnxqsz xnxqsz, Result result);

	/**
	 * 添加
	 * 
	 */
	public Result save(Xnxqsz xnxqsz, Result result);

	/**
	 * 删除
	 * 
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 导出
	 * 
	 */
	public List<Xnxqsz> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;


}

