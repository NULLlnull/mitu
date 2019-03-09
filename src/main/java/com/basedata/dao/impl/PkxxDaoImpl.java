package com.basedata.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.basedata.base.impl.BaseDaoImpl;
import com.basedata.dao.IPkxxDao;
import com.basedata.model.Pkxx;

@Repository
public class PkxxDaoImpl extends BaseDaoImpl<Pkxx> implements IPkxxDao {

	/**
	 * 获取筛选 教师
	 */
	@Override
	public List<Pkxx> getTeachers() {
		return getSqlSession().selectList(this.getClassName() + ".getTeachers");
	}

	/**
	 * 获取筛选 场地
	 */
	@Override
	public List<Pkxx> getSpaces() {
		return getSqlSession().selectList(this.getClassName() + ".getSpaces");
	}

	/**
	 * 条件筛选数据
	 */
	@Override
	public List<Pkxx> getPkxx(Map<String, String> params) {
		return getSqlSession().selectList(this.getClassName() + ".getPkxx", params);
	}

	/**
	 * 根据教学任务ID获取排课信息
	 */
	@Override
	public List<Pkxx> getByJxrwId(String jxrwId) {
		return getSqlSession().selectList(this.getClassName() + ".getByJxrwId", jxrwId);
	}

}
