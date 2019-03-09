package com.basedata.dao;

import com.basedata.base.BaseDao;
import com.basedata.model.User;

public interface IUserDao extends BaseDao<User> {

	/**
	 * 根据用户名查询
	 * 
	 * @param username
	 * @return
	 */
	public User queryByName(String username);
}
