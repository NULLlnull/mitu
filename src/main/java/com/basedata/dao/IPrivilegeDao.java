package com.basedata.dao;

import com.basedata.base.BaseDao;
import com.basedata.model.Privilege;

public interface IPrivilegeDao extends BaseDao<Privilege> {

	void deleteByRoleId(String roleId);

}
