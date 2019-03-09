package com.basedata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.basedata.model.Pkxx;

public interface IPkxxService {

	/**
	 * 筛选所有的教师
	 */
	List<Pkxx> getTeachers();

	/**
	 * 获取筛选 场地
	 */
	List<Pkxx> getSpaces();

	/**
	 * 条件筛选数据
	 */
	List<HashMap<String, Object>> getPkxx(Map<String, String> params);

	/**
	 * 根据教学任务ID获取排课信息
	 */
	List<HashMap<String, Object>> loadPkxxByclazz(Map<String, String> params);

}
