package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Xsxx;
import com.basedata.service.IXsxxService;
import com.basedata.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Xsxx
 */
@RequestMapping("/xsxx")
@Controller
public class XsxxController extends BaseController<Xsxx> {

    @Autowired
    private IXsxxService xsxxService;

    /**
     * 列表
     */
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public String list(ModelMap model, Xsxx xsxx) {
        DataTables dataTables = DataTables.getInstance(request, null);
        PageView pageView = new PageView(SystemContext.getOffset());
        xsxxService.query(pageView, xsxx, dataTables, request);
        return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
    }

    /**
     * 详情
     */
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(ModelMap model, String id) {
        return JSONObject.toJSONString(xsxxService.getById(id));
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(Xsxx xsxx) {
        Result result = new Result();
        result = xsxxService.update(xsxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(Xsxx xsxx) {
        Result result = new Result();
        result = xsxxService.save(xsxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
    public String del(@RequestParam("ids[]") List<Integer> ids) {
        Result result = new Result();
        result = xsxxService.delByIds(ids, result);
        return JSONObject.toJSONString(result);
    }

}

