package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Zddm;
import com.basedata.service.IZddmService;
import com.basedata.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Zddm
 */
@RequestMapping("/zddm")
@Controller
public class ZddmController extends BaseController<Zddm> {

    @Autowired
    private IZddmService zddmService;

    /**
     * 列表
     */
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public String list(ModelMap model, Zddm zddm) {
        DataTables dataTables = DataTables.getInstance(request, null);
        PageView pageView = new PageView(SystemContext.getOffset());
        zddmService.query(pageView, zddm, dataTables, request);
        return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
    }

    /**
     * 详情
     */
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(ModelMap model, String id) {
        return JSONObject.toJSONString(zddmService.getById(id));
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(Zddm zddm) {
        Result result = new Result();
        result = zddmService.update(zddm, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(Zddm zddm) {
        Result result = new Result();
        result = zddmService.save(zddm, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
    public String del(@RequestParam("ids[]") List<Integer> ids) {
        Result result = new Result();
        result = zddmService.delByIds(ids, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 根据字典类别获取数据
     *
     * @param zdlbs
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "property.do", produces = "application/json; charset=utf-8")
    public String property(String zdlbs) {
        Result result = zddmService.property(zdlbs);
        return JSONObject.toJSONString(result);
    }
}

