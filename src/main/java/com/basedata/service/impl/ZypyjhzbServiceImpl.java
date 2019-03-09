package com.basedata.service.impl;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.service.IZddmService;
import com.basedata.utils.SessionUtils;
import com.basedata.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.basedata.dao.IZypyjhzbDao;
import com.basedata.model.Zypyjhzb;
import com.basedata.service.IZypyjhzbService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ZypyjhzbServiceImpl implements IZypyjhzbService {

    @Autowired
    private IZypyjhzbDao zypyjhzbDao;

    @Autowired
    private IZddmService zddmService;

    /**
     * 获取查询条件
     */
    private HashMap<String, String> getSearchMap(DataTables dataTables, HttpServletRequest request) {
        StringBuffer subSql = new StringBuffer();
        if (!StringUtils.isEmpty(request.getParameter("publishTypeId"))) {
            subSql.append(" and publishTypeId = ").append(request.getParameter("publishTypeId"));
        }
        if (!StringUtils.isEmpty(request.getParameter("timeMin"))) {
            subSql.append(" and publishDate >= '").append(request.getParameter("timeMin")).append("'");
        }
        if (!StringUtils.isEmpty(request.getParameter("timeMax"))) {
            subSql.append(" and publishDate <= '").append(request.getParameter("timeMax")).append("'");
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition", dataTables.getSearch());
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        return params;
    }

    /**
     * 字典转换
     */
    private List<Zypyjhzb> zddmConvert(List<Zypyjhzb> list) {
        //字典转换
        HashMap<String, String> zddmMap = Utils.getZddmMap(zddmService, "刊物类型,本人排名");
        for (Object object : list) {
            Zypyjhzb o = (Zypyjhzb) object;
            //o.setMyRankName(Utils.getInMap(zddmMap, o.getMyRankId()));
        }
        return list;
    }

    /**
     * 列表
     */
    @Override
    public PageView query(PageView pageView, Zypyjhzb zypyjhzb, DataTables dataTables, HttpServletRequest request) {
        HashMap<String, String> params = getSearchMap(dataTables, request);
        List<Zypyjhzb> list = zddmConvert(zypyjhzbDao.query(pageView, zypyjhzb, params));
        pageView.setRecords(list);
        return pageView;
    }

    /**
     * 详情
     */
    @Override
    public Zypyjhzb getById(String id) {
        try {
            return zypyjhzbDao.getById(id);
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
    public Result update(Zypyjhzb zypyjhzb, Result result) {
        try {
            zypyjhzbDao.update(zypyjhzb);
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
    public Result save(Zypyjhzb zypyjhzb, Result result) {
        try {
            zypyjhzbDao.save(zypyjhzb);
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
            zypyjhzbDao.deleteByPrimaryKeys(ids);
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
    public List<Zypyjhzb> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
        HashMap<String, String> params = getSearchMap(dataTables, request);
        List<Zypyjhzb> zypyjhzbs = zddmConvert(zypyjhzbDao.query(params));
        return zypyjhzbs;
    }

    /**
     * 根据教师Id获取
     */
    @Override
    public List<Zypyjhzb> getByTeacherId(String teacherId) {
        StringBuffer subSql = new StringBuffer("teacherId = '" + teacherId + "'");
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("subSql", subSql.toString());
        List<Zypyjhzb> zypyjhzbs = zddmConvert(zypyjhzbDao.query(params));
        return zypyjhzbs;
    }

}


