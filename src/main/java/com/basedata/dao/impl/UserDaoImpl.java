package com.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.basedata.base.impl.BaseDaoImpl;
import com.basedata.dao.IUserDao;
import com.basedata.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
	/**
	 * 根据用户名查询
	 * 
	 * @param username
	 * @return
	 */
	@Override
	public User queryByName(String username) {
		return getSqlSession().selectOne(this.getClassName() + ".queryByName", username);
	}
}
