package com.basedata.controller;

import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basedata.annotation.NeedLogin;

public class BaseController<T> {

	@Autowired
	public HttpServletRequest request;

	@Autowired
	public HttpSession session;

	@Autowired
	public HttpServletResponse response;

	/**
	 * 列表页
	 * 
	 * @return
	 */
	@NeedLogin
	@RequestMapping(value = "toList.do")
	public String toList(ModelMap model, String resId) {
		model.addAttribute("resId", resId);
		return getClassName() + "/list";
	}

	@RequestMapping(value = "toListAll.do")
	public String toListAll() {
		return getClassName() + "/listAll";
	}

	/**
	 * 班级详情页
	 * 
	 * @return
	 */
	@NeedLogin
	@RequestMapping(value = "toEdit.do")
	public String toEdit() {
		return getClassName() + "/edit";
	}

	/**
	 * 
	 * 获取传过来的泛型类名
	 * 
	 * @return
	 */
	public String getClassName() {
		// 在父类中得到子类声明的父类的泛型信息
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class) pt.getActualTypeArguments()[0];
		// 这里是获取实体类的简单名称，再把类名转为小写
		return clazz.getSimpleName().toString().toLowerCase();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
