package com.basedata.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.basedata.annotation.NeedLogin;
import com.basedata.model.Menu;
import com.basedata.service.IUserService;
import com.basedata.utils.SessionUtils;

@Controller
public class PageController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "login.do")
	public String login() {
		return "login";
	}

	@NeedLogin
	@RequestMapping(value = "index.do")
	public String index() {
		return "index";
	}

	@NeedLogin
	@RequestMapping(value = "head.do")
	public String head() {
		return "common/head";
	}

	@NeedLogin
	@RequestMapping(value = "left.do")
	public String left(ModelMap model, HttpServletRequest request) {
		List<Menu> menuList = userService.getMenus(SessionUtils.getUser(request), request);
		List<Menu> parentMenu = new ArrayList<Menu>();
		List<Menu> childMenu = new ArrayList<Menu>();
		for (int i = 0; i < menuList.size(); i++) {
			Menu menu = menuList.get(i);
			if (menu.getParentId() == -1) {
				parentMenu.add(menu);
			} else {
				childMenu.add(menu);
			}
		}
		model.addAttribute("parentMenu", parentMenu);
		model.addAttribute("childMenu", childMenu);
		return "common/left";
	}

	@NeedLogin
	@RequestMapping(value = "main.do")
	public String main() {
		return "common/main";
	}

}
