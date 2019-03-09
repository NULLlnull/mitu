package com.basedata.service.impl;

import com.basedata.dao.IJxrwDao;
import com.basedata.dao.IPkxxDao;
import com.basedata.model.Jxrw;
import com.basedata.model.Pkxx;
import com.basedata.service.IPkxxService;
import com.basedata.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PkxxServiceImpl implements IPkxxService {

    @Autowired
    private IPkxxDao pkxxDao;

    @Autowired
    private IJxrwDao jxrwDao;

    /**
     * 获取筛选 教师
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public List<Pkxx> getTeachers() {
        return pkxxDao.getTeachers();
    }

    /**
     * 获取筛选 场地
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public List<Pkxx> getSpaces() {
        return pkxxDao.getSpaces();
    }

    /**
     * 条件筛选数据
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public List<HashMap<String, Object>> getPkxx(Map<String, String> params) {
        List<HashMap<String, Object>> result = new ArrayList<>();
        // 查询所有符合条件的排课信息
        List<Pkxx> pkxxs = pkxxDao.getPkxx(params);
        System.out.println("[pkxx.service]pkxxs.size=" + pkxxs.size());
        // 查询对应的教学任务
        for (Pkxx pkxx : pkxxs) {
            HashMap<String, Object> data = new HashMap<>();
            int jxrwId = pkxx.getJxrwid();
            //System.out.println("[pkxx.service]" + pkxx.getSkjsxm() + ",jxrwId=" + jxrwId);
            Jxrw jxrw = jxrwDao.getById(String.valueOf(jxrwId));
            if (jxrw == null)
                continue;
            data.put("xqs", pkxx.getXqs());
            data.put("jc", pkxx.getJc());
            data.put("skjsxm", StringUtils.isNotBlank(pkxx.getSkjsxm()) ? pkxx.getSkjsxm() : "");
            data.put("kcmc", jxrw.getKcmc());
            data.put("ssbj", jxrw.getSsbj());
            data.put("bjmc", jxrw.getBjmc());
            data.put("pkzc", "[" + pkxx.getPkzcshow() + "周]");
            data.put("skcdmc", StringUtils.isNotBlank(pkxx.getSkcdmc()) ? pkxx.getSkcdmc() : "");
            result.add(data);
        }
        return result;
    }

    /**
     * 根据教学任务ID获取排课信息
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public List<HashMap<String, Object>> loadPkxxByclazz(Map<String, String> params) {
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        List<Jxrw> jxrws = jxrwDao.getByClazz(params);

        // 查询对应的排课信息
        for (Jxrw jxrw : jxrws) {
            String jxrwId = String.valueOf(jxrw.getId());
            List<Pkxx> pkxxs = pkxxDao.getByJxrwId(jxrwId);
            for (Pkxx pkxx : pkxxs) {
                HashMap<String, Object> data = new HashMap<String, Object>();
                data.put("xqs", pkxx.getXqs());
                data.put("jc", pkxx.getJc());
                data.put("skjsxm", StringUtils.isNotBlank(pkxx.getSkjsxm()) ? pkxx.getSkjsxm() : "");
                data.put("kcmc", jxrw.getKcmc());
                data.put("bjmc", jxrw.getBjmc());
                data.put("pkzc", "[" + pkxx.getPkzcshow() + "周]");
                data.put("title", jxrw.getSsxbmc() + " " + jxrw.getBjmc() + " 班级课程表 (" + jxrw.getXn() + "第"
                        + jxrw.getXq() + "学期)");
                result.add(data);
            }
        }
        return result;
    }

}
