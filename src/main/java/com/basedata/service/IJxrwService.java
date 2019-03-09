package com.basedata.service;

import java.util.List;

import com.basedata.model.Bjxx;
import com.basedata.model.Jxrw;
import com.basedata.model.Jxrw;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

import javax.servlet.http.HttpServletRequest;

public interface IJxrwService {

	/**
	 * 教室信息列表页
	 *
	 * @param pageView
	 * @param jxrw
	 * @return
	 */
	public PageView query(PageView pageView, Jxrw jxrw, DataTables dataTables, HttpServletRequest request);

	/**
	 * 教室信息详情页
	 *
	 * @param id
	 * @return
	 */
	public Jxrw getById(String id);

	/**
	 * 更新实体
	 *
	 * @param jxrw
	 */
	public Result update(Jxrw jxrw, Result result);

	/**
	 * 添加记录
	 *
	 * @param jxrw
	 * @param result
	 * @return
	 */
	public Result save(Jxrw jxrw, Result result);

	/**
	 * 删除记录
	 *
	 * @param ids
	 * @param result
	 * @return
	 */
	public Result delByIds(List<Integer> ids, Result result);

	/**
	 * 筛选所有的班级
	 * @return
	 */
	List<Jxrw> getClazz();

}
