package com.basedata.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.basedata.constant.Dict;
import com.basedata.model.Ryjcxx;
import com.basedata.model.User;

public class SessionUtils {

	/**
	 * 获取session中对象
	 * 
	 * @param request
	 * @return
	 */
	public static Ryjcxx getRyjcxx(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Dict._cutrrent_teacher);
		if (obj != null) {
			return (Ryjcxx) obj;
		}
		return null;
	}

	/**
	 * 设置session对象
	 * 
	 * @param request
	 * @return
	 */
	public static void setRyjcxx(HttpServletRequest request, Ryjcxx ryjcxx) {
		request.getSession().setAttribute(Dict._cutrrent_teacher, ryjcxx);
	}

	/**
	 * 获取session中对象
	 * 
	 * @param request
	 * @return
	 */
	public static User getUser(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Dict._cutrrent_user);
		if (obj != null) {
			return (User) obj;
		}
		return null;
	}

	/**
	 * 设置session对象
	 * 
	 * @param request
	 * @return
	 */
	public static void setUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(Dict._cutrrent_user, user);
	}

	/**
	 * 获取session中对象
	 * 
	 * @param request
	 * @return
	 */
	public static HashMap<String, Boolean> getPrivilege(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Dict._cutrrent_privilege);
		if (obj != null) {
			return (HashMap<String, Boolean>) obj;
		}
		return null;
	}

	/**
	 * 设置session对象
	 * 
	 * @param request
	 * @return
	 */
	public static void setPrivilege(HttpServletRequest request, Map<String, Boolean> map) {
		request.getSession().setAttribute(Dict._cutrrent_privilege, map);
	}

}
