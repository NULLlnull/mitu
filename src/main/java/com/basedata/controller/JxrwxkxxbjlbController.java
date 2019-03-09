package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Jxrwxkxxbjlb;
import com.basedata.service.IJxrwxkxxbjlbService;
import com.basedata.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @ 论文
 */
@RequestMapping("/jxrwxkxxbjlb")
@Controller
public class JxrwxkxxbjlbController extends BaseController<Jxrwxkxxbjlb> {

    @Autowired
    private IJxrwxkxxbjlbService jxrwxkxxbjlbService;

    /**
     * 列表
     */
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public String list(ModelMap model, Jxrwxkxxbjlb jxrwxkxxbjlb) {
        return null;
    }

    /**
     * 详情
     */
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(String id) {
        return JSONObject.toJSONString(jxrwxkxxbjlbService.getById(id), SerializerFeature.WriteMapNullValue);
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(@RequestParam("files") MultipartFile[] files, Jxrwxkxxbjlb jxrwxkxxbjlb) {
        Result result = new Result();
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(@RequestParam("files") MultipartFile[] files, Jxrwxkxxbjlb jxrwxkxxbjlb) {
        Result result = new Result();
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
    public String del(@RequestParam("ids[]") List<Integer> ids) {
        Result result = new Result();
        result = jxrwxkxxbjlbService.delByIds(ids, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 导出execl
     */
    @RequestMapping(value = "exportExecl.do")
    @ResponseBody
    public Map<String, Object> exportExecl() throws Exception {
        return null;
    }

}

