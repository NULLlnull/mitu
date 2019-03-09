package com.basedata.dao;

import java.util.List;

import com.basedata.base.BaseDao;
import com.basedata.model.Zddm;

public interface IZddmDao extends BaseDao<Zddm> {

	/**
	 * 获取字典类别数据
	 * 
	 * @param zdlb
	 * @return
	 */
	List<Zddm> property(String zdlb);

}
