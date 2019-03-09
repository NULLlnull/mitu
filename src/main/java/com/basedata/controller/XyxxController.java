package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Xyxx;
import com.basedata.service.IXyxxService;
import com.basedata.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Xyxx
 */
@RequestMapping("/xyxx")
@Controller
public class XyxxController extends BaseController<Xyxx> {

    @Autowired
    private IXyxxService xyxxService;

    /**
     * 学院信息
     *
     * @param model
     * @param xyxx
     * @return
     */
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(ModelMap model, Xyxx xyxx) {
        PageView pageView = new PageView(SystemContext.getOffset());
        xyxxService.query(pageView, xyxx);
        return JSONObject.toJSONString(pageView.getRecords().get(0));
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(Xyxx xyxx) {
        Result result = new Result();
        result = xyxxService.update(xyxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(Xyxx xyxx) {
        Result result = new Result();
        result = xyxxService.save(xyxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
    public String del(@RequestParam("ids[]") List<Integer> ids) {
        Result result = new Result();
        result = xyxxService.delByIds(ids, result);
        return JSONObject.toJSONString(result);
    }

}

