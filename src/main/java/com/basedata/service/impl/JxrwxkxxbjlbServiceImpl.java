package com.basedata.service.impl;

import com.basedata.vo.DataTables;
import com.basedata.dao.IJxrwxkxxbjlbDao;
import com.basedata.model.Jxrwxkxxbjlb;
import com.basedata.service.IJxrwxkxxbjlbService;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class JxrwxkxxbjlbServiceImpl implements IJxrwxkxxbjlbService {

    @Autowired
    private IJxrwxkxxbjlbDao jxrwxkxxbjlbDao;

    /**
     * 获取查询条件
     */
    private HashMap<String, String> getSearchMap(DataTables dataTables, HttpServletRequest request) {
        StringBuffer subSql = new StringBuffer("");
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition", dataTables.getSearch());
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        return params;
    }

    /**
     * 字典转换
     */
    private List<Jxrwxkxxbjlb> zddmConvert(List<Jxrwxkxxbjlb> list) {
        return list;
    }

    /**
     * 列表
     */
    @Override
    public PageView query(PageView pageView, Jxrwxkxxbjlb jxrwxkxxbjlb, DataTables dataTables, HttpServletRequest request) {
        HashMap<String, String> params = getSearchMap(dataTables, request);
        List<Jxrwxkxxbjlb> list = zddmConvert(jxrwxkxxbjlbDao.query(pageView, jxrwxkxxbjlb));
        pageView.setRecords(list);
        return pageView;
    }

    /**
     * 详情
     */
    @Override
    public Jxrwxkxxbjlb getById(String id) {
        try {
            return jxrwxkxxbjlbDao.getById(id);
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
    public Result update(Jxrwxkxxbjlb jxrwxkxxbjlb, Result result) {
        try {
            jxrwxkxxbjlbDao.update(jxrwxkxxbjlb);
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
    public Result save(Jxrwxkxxbjlb jxrwxkxxbjlb, Result result) {
        try {
            jxrwxkxxbjlbDao.save(jxrwxkxxbjlb);
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
//            jxrwxkxxbjlbDao.deleteByPrimaryKeys(ids);
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
    public List<Jxrwxkxxbjlb> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
        HashMap<String, String> params = getSearchMap(dataTables, request);
        List<Jxrwxkxxbjlb> jxrwxkxxbjlbs = null;//zddmConvert(jxrwxkxxbjlbDao.query(params));
        return jxrwxkxxbjlbs;
    }

}


