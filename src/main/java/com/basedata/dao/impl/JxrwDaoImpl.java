package com.basedata.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.basedata.base.impl.BaseDaoImpl;
import com.basedata.dao.IJxrwDao;
import com.basedata.model.Jxrw;

@Repository
public class JxrwDaoImpl extends BaseDaoImpl<Jxrw> implements IJxrwDao {

	/**
	 * 筛选项 班级
	 */
	@Override
	public List<Jxrw> getClazz() {
		return getSqlSession().selectList(this.getClassName() + ".getClazz");
	}

	/**
	 * 根据班级获取教学任务
	 */
	@Override
	public List<Jxrw> getByClazz(Map<String, String> params) {
		return getSqlSession().selectList(this.getClassName() + ".getByClazz", params);
	}

}
