package com.basedata.dao;

import java.util.List;
import java.util.Map;

import com.basedata.base.BaseDao;
import com.basedata.model.Pkxx;

public interface IPkxxDao extends BaseDao<Pkxx> {

	/**
	 * 获取筛选 教师
	 */
	List<Pkxx> getTeachers();

	/**
	 * 获取筛选 场地
	 */
	List<Pkxx> getSpaces();

	/**
	 * 条件筛选数据
	 */
	List<Pkxx> getPkxx(Map<String, String> params);

	/**
	 * 根据教学任务ID获取排课信息
	 */
	List<Pkxx> getByJxrwId(String jxrwId);

}
