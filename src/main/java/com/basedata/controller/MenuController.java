package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Menu;
import com.basedata.service.IMenuService;
import com.basedata.utils.Utils;
import com.basedata.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Menu
 */
@RequestMapping("/menu")
@Controller
public class MenuController extends BaseController<Menu> {

    @Autowired
    private IMenuService menuService;

    /**
     * 列表
     */
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public String list(ModelMap model, Menu menu) {
        DataTables dataTables = DataTables.getInstance(request, null);
        PageView pageView = new PageView(SystemContext.getOffset());
        menuService.query(pageView, menu, dataTables, request);
        return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
    }

    /**
     * 详情
     */
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(ModelMap model, String id) {
        return JSONObject.toJSONString(menuService.getById(id));
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(Menu menu) {
        Result result = new Result();
        result = menuService.update(menu, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(Menu menu) {
        Result result = new Result();
        result = menuService.save(menu, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
    public String del(@RequestParam("ids[]") List<Integer> ids) {
        Result result = new Result();
        result = menuService.delByIds(ids, result);
        return JSONObject.toJSONString(result);
    }

}

