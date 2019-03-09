package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedLogin;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Bjxx;
import com.basedata.service.IBjxxService;
import com.basedata.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Bjxx
 */
@RequestMapping("/bjxx")
@Controller
public class BjxxController extends BaseController<Bjxx> {

    @Autowired
    private IBjxxService bjxxService;

    /**
     * 列表
     */
    @NeedLogin
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "listAll.do", produces = "application/json; charset=utf-8")
    public String listAll(ModelMap model, Bjxx bjxx) {
        List<Bjxx> list = bjxxService.queryAll(bjxx);
        return JSONObject.toJSONString(list);
    }

    /**
     * 列表
     */
    @NeedLogin
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public String list(ModelMap model, Bjxx bjxx) {
        DataTables dataTables = DataTables.getInstance(request, null);
        PageView pageView = new PageView(SystemContext.getOffset());
        bjxxService.query(pageView, bjxx, dataTables, request);
        return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
    }

    /**
     * 详情
     */
    @NeedLogin
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(ModelMap model, String id) {
        return JSONObject.toJSONString(bjxxService.getById(id));
    }

    /**
     * 更新
     */
    @NeedLogin
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(Bjxx bjxx) {
        Result result = new Result();
        result = bjxxService.update(bjxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @NeedLogin
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(Bjxx bjxx) {
        Result result = new Result();
        result = bjxxService.save(bjxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除
     */
    @NeedLogin
    @ResponseBody
    @RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
    public String del(@RequestParam("ids[]") List<Integer> ids) {
        Result result = new Result();
        result = bjxxService.delByIds(ids, result);
        return JSONObject.toJSONString(result);
    }

}

