package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.basedata.annotation.NeedLogin;
import com.basedata.annotation.NeedPage;
import com.basedata.constant.Dict;
import com.basedata.model.Zyksnj;
import com.basedata.service.IZyksnjService;
import com.basedata.service.IZddmService;
import com.basedata.utils.*;
import com.basedata.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @ 论文
 */
@RequestMapping("/zyksnj")
@Controller
public class ZyksnjController extends BaseController<Zyksnj> {

    @Autowired
    private IZyksnjService zyksnjService;

    @Autowired
    private IZddmService zddmService;

    /**
     * 列表
     */
    @NeedLogin
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public String list(ModelMap model, Zyksnj zyksnj) {
        DataTables dataTables = DataTables.getInstance(request, null);
        PageView pageView = new PageView(SystemContext.getOffset());
        zyksnjService.query(pageView, zyksnj, dataTables, request);
        return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
    }

    /**
     * 详情
     */
    @NeedLogin
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(String id) {
        return JSONObject.toJSONString(zyksnjService.getById(id), SerializerFeature.WriteMapNullValue);
    }

    /**
     * 更新
     */
    @NeedLogin
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(@RequestParam("files") MultipartFile[] files, Zyksnj zyksnj) {
        Result result = new Result();
        result = zyksnjService.update(zyksnj, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @NeedLogin
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(@RequestParam("files") MultipartFile[] files, Zyksnj zyksnj) {
        Result result = new Result();
        result = zyksnjService.save(zyksnj, result);
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
        result = zyksnjService.delByIds(ids, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 导出execl
     */
    @NeedLogin
    @RequestMapping(value = "exportExecl.do")
    @ResponseBody
    public Map<String, Object> exportExecl() throws Exception {
        // 获取导出数据
        DataTables dataTables = DataTables.getInstance(request, null);
        List<Zyksnj> data = zyksnjService.exportData(dataTables, request);
        //写入Excel的数据
        List<String[]> list = toStrArr(data);

        String fileName = new Date().getTime() + ".xls";
        ServletUtil su = new ServletUtil(fileName, request, response);
        ExcelUtils excelUtils = new ExcelUtils("论文", heads, list, su.getOut());
        excelUtils.exportExcel();
        return null;
    }

    public String[] heads = {"名称", "刊物学报", "刊号", "刊物类别", "本人排名", "出版日期"};

    /**
     * 实体类转字符串数组
     */
    public List<String[]> toStrArr(List<Zyksnj> list) {
        List<String[]> list_result = new ArrayList<>();
        for (Zyksnj zyksnj : list) {
            String[] arr = new String[heads.length];
            //arr[0] = zyksnj.getZyksnjName();
            //arr[1] = zyksnj.getPublishName();
            //arr[2] = zyksnj.getIsbn();
            //arr[3] = zyksnj.getPublishTypeName();
            //arr[4] = zyksnj.getMyRankName();
            //arr[5] = DateUtils.formatDate(zyksnj.getPublishDate());
            list_result.add(arr);
        }
        return list_result;
    }
}

