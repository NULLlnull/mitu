package com.basedata.service.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.basedata.dao.IJzlxxDao;
import com.basedata.model.Jzlxx;
import com.basedata.service.IJzlxxService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class JzlxxServiceImpl implements IJzlxxService {

    @Autowired
    private IJzlxxDao JzlxxDao;

    /**
     * 列表
     */
    @Override
    public PageView query(PageView pageView, Jzlxx Jzlxx, DataTables dataTables, HttpServletRequest request) {
        StringBuffer subSql = new StringBuffer(" ");
        if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
            //subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition", dataTables.getSearch());
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        List<Jzlxx> list = JzlxxDao.query(pageView, Jzlxx, params);
        pageView.setRecords(list);
        return pageView;
    }

    /**
     * 详情
     */
    @Override
    public Jzlxx getById(String id) {
        try {
            return JzlxxDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result update(Jzlxx jzlxx, Result result) {
        try {
            System.out.println("[JzlxxDao]getJzlmc=" + jzlxx.getJzlmc() + ",id=" + jzlxx.getId());
            JzlxxDao.update(jzlxx);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(-1);
        }
        return result;
    }

    /**
     * 添加
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result save(Jzlxx jzlxx, Result result) {
        try {
            JzlxxDao.save(jzlxx);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(-1);
        }
        return result;
    }

    /**
     * 删除
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result delByIds(List<Integer> ids, Result result) {
        try {
            JzlxxDao.deleteByPrimaryKeys(ids);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(-1);
        }
        return result;
    }

    /**
     * 导出数据
     */
    @Override
    public List<Jzlxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
        StringBuffer subSql = new StringBuffer(" ");
        if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
            //subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition",
                URLDecoder.decode(dataTables.getSearch() != null ? dataTables.getSearch() : "", "UTF-8"));
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        List<Jzlxx> Jzlxxs = JzlxxDao.query(params);
        return Jzlxxs;
    }

}

