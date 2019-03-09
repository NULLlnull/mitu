package com.basedata.controller;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedLogin;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Zyxx;
import com.basedata.service.IZyxxService;
import com.basedata.vo.ExcelUtils;
import com.basedata.utils.ServletUtil;
import com.basedata.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Zyxx
 */
@RequestMapping("/zyxx")
@Controller
public class ZyxxController extends BaseController<Zyxx> {

    @Autowired
    private IZyxxService zyxxService;

    /**
     * 列表
     */
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public String list(ModelMap model, Zyxx zyxx) {
        DataTables dataTables = DataTables.getInstance(request, null);
        PageView pageView = new PageView(SystemContext.getOffset());
        zyxxService.query(pageView, zyxx, dataTables, request);
        return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
    }

    /**
     * 详情
     */
    @ResponseBody
    @RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
    public String edit(ModelMap model, String id) {
        return JSONObject.toJSONString(zyxxService.getById(id));
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping(value = "update.do", produces = "application/json; charset=utf-8")
    public String update(Zyxx zyxx) {
        Result result = new Result();
        result = zyxxService.update(zyxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
    public String add(Zyxx zyxx) {
        Result result = new Result();
        result = zyxxService.save(zyxx, result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
    public String del(@RequestParam("ids[]") List<Integer> ids) {
        Result result = new Result();
        result = zyxxService.delByIds(ids, result);
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
        List<Zyxx> data = zyxxService.exportData(dataTables, request);
        //写入Excel的数据
        List<String[]> list = toStrArr(data);

        String fileName = new Date().getTime() + ".xls";
        ServletUtil su = new ServletUtil(fileName, request, response);
        ExcelUtils excelUtils = new ExcelUtils("专业信息", heads, list, su.getOut());
        excelUtils.exportExcel();
        return null;
    }

    public String[] heads = {"院内专业代码", "院内专业名称", "招生专业代码", "招生专业名称", "所属系部", "培养对象", "培养层次", "学制"};

    /**
     * 实体类转字符串数组
     */
    public List<String[]> toStrArr(List<Zyxx> list) {
        List<String[]> list_result = new ArrayList<>();
        for (Zyxx zyxx : list) {
            String[] arr = new String[heads.length];
            arr[0] = zyxx.getYnzydm();
            arr[1] = zyxx.getYnzymc();
            arr[2] = zyxx.getZszydm();
            arr[3] = zyxx.getZszymc();
            arr[4] = zyxx.getSsxbName();
            arr[5] = zyxx.getPydxName();
            arr[6] = zyxx.getPyccName();
            arr[7] = zyxx.getXz() + "";
            list_result.add(arr);
        }
        return list_result;
    }
}

