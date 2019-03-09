package com.basedata.dao;

import java.util.List;
import java.util.Map;

import com.basedata.base.BaseDao;
import com.basedata.model.Jxrw;

public interface IJxrwDao extends BaseDao<Jxrw> {

	/**
	 * 筛选项 班级
	 */
	List<Jxrw> getClazz();

	/**
	 * 根据班级获取教学任务
	 */
	List<Jxrw> getByClazz(Map<String, String> params);

}
