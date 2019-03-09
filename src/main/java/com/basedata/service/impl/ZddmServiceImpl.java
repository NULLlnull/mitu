package com.basedata.service.impl;

import com.basedata.dao.IZddmDao;
import com.basedata.model.Zddm;
import com.basedata.service.IZddmService;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ZddmServiceImpl implements IZddmService {

    @Autowired
    private IZddmDao zddmDao;

    /**
     * 列表
     */
    @Override
    public PageView query(PageView pageView, Zddm Zddm, DataTables dataTables, HttpServletRequest request) {
        StringBuffer subSql = new StringBuffer(" ");
        if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
            //subSql.append(" and xxxId = ").append(request.getParameter("xxxId"));
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition", dataTables.getSearch());
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        List<Zddm> list = zddmDao.query(pageView, Zddm, params);
        pageView.setRecords(list);
        return pageView;
    }

    /**
     * 详情
     */
    @Override
    public Zddm getById(String id) {
        try {
            return zddmDao.getById(id);
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
    public Result update(Zddm zddm, Result result) {
        try {
            if (zddm.getSort() == null)
                zddm.setSort(Short.parseShort("1"));
            if (zddm.getPykssy() == null)
                zddm.setPykssy("");
            zddm.setXsbz(Byte.parseByte("1"));
            zddm.setFqbz(Byte.parseByte("0"));
            zddmDao.update(zddm);
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
    public Result save(Zddm zddm, Result result) {
        try {
            if (zddm.getSort() == null)
                zddm.setSort(Short.parseShort("1"));
            if (zddm.getPykssy() == null)
                zddm.setPykssy("");
            zddm.setXsbz(Byte.parseByte("1"));
            zddm.setFqbz(Byte.parseByte("0"));
            zddmDao.save(zddm);
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
            zddmDao.deleteByPrimaryKeys(ids);
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
    public List<Zddm> exportData(DataTables dataTables, HttpServletRequest request) {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("condition", dataTables.getSearch());
            List<Zddm> list = zddmDao.query(params);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Zddm>();

    }

    /**
     * 根据字典类别获取数据
     */
    @Override
    public Result property(String zdlbs) {
        Result result = new Result();
        try {
            HashMap<String, List<Zddm>> data = new HashMap<>();
            String[] arr = zdlbs.split(",");
            for (String zdlb : arr) {
                data.put(zdlb, zddmDao.property(zdlb));
//                System.out.println("[zddm.service]" + zdlb + zddmDao.property(zdlb).size());
            }
            result.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

