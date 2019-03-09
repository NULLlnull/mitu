package com.basedata.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Xyjgxx;
import com.basedata.service.IXyjgxxService;
import com.basedata.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Xyjgxx
 */
@RequestMapping("/xyjgxx")
@Controller
public class XyjgxxController extends BaseController<Xyjgxx> {

    @Autowired
    private IXyjgxxService xyjgxxService;

    /**
     * 学院架构信息
     */
    @NeedPage
    @ResponseBody
    @RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
    public JSONArray list(HttpServletRequest request, Xyjgxx xyjgxx) {
        int jxjg = Utils.toInt(request.getParameter("jxjg"));
        List<Xyjgxx> list = xyjgxxService.findAll(xyjgxx);
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            Xyjgxx _xyjgxx = list.get(i);
            //需要判断是否教学机构
            if (jxjg == 1 && Utils.toByte(_xyjgxx.getSfjxxb()) == 0)
                continue;
            JSONObject obj = new JSONObject();
            obj.put("id", _xyjgxx.getId());
            obj.put("pId", _xyjgxx.getPid());
            obj.put("jgdm", _xyjgxx.getJgdm());
            obj.put("name", _xyjgxx.getJgmc());
            obj.put("open", false);
            array.add(obj);
        }
        return array;
    }

}

