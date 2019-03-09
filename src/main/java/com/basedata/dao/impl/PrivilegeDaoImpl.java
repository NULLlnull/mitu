package com.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.basedata.base.impl.BaseDaoImpl;
import com.basedata.dao.IPrivilegeDao;
import com.basedata.model.Privilege;

@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao {

	@Override
	public void deleteByRoleId(String roleId) {
		getSqlSession().delete(this.getClassName() + ".deleteByRoleId", roleId);
	}

}
