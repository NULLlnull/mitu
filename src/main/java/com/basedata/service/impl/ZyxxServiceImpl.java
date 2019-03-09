package com.basedata.service.impl;

import com.basedata.dao.IXyjgxxDao;
import com.basedata.dao.IZyxxDao;
import com.basedata.model.Xyjgxx;
import com.basedata.model.Zyxx;
import com.basedata.service.IZddmService;
import com.basedata.service.IZyxxService;
import com.basedata.utils.Utils;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ZyxxServiceImpl implements IZyxxService {

    @Autowired
    private IZyxxDao zyxxDao;

    @Autowired
    private IZddmService zddmService;

    @Autowired
    private IXyjgxxDao xyjgxxDao;

    /**
     * 获取查询条件
     */
    private HashMap<String, String> getSearchMap(DataTables dataTables, HttpServletRequest request) {
        StringBuffer subSql = new StringBuffer();
        if (!StringUtils.isEmpty(request.getParameter("pydxDm"))) {
            subSql.append(" and pydxDm = '").append(request.getParameter("pydxDm")).append("'");
        }
        if (!StringUtils.isEmpty(request.getParameter("pyccDm"))) {
            subSql.append(" and pyccDm = '").append(request.getParameter("pyccDm")).append("'");
        }
        if (!StringUtils.isEmpty(request.getParameter("ssxb"))) {
            subSql.append(" and ssxb = '").append(request.getParameter("ssxb")).append("'");
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition", dataTables.getSearch());
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        return params;
    }

    /**
     * 字典转换
     */
    private List<Zyxx> zddmConvert(List<Zyxx> list) {
        //字典转换
        HashMap<String, String> zddmMap = Utils.getZddmMap(zddmService, "培养对象,培养层次");
        for (Object object : list) {
            Zyxx o = (Zyxx) object;
            o.setPyccName(Utils.getInMap(zddmMap, o.getPyccDm()));
            o.setPydxName(Utils.getInMap(zddmMap, o.getPydxDm()));

            HashMap<String, String> params = new HashMap<String, String>();
            params.put("condition", o.getSsxb());
            Xyjgxx xyjgxx = xyjgxxDao.queryOne(params);
            if (xyjgxx != null) {
                o.setSsxbName(xyjgxx.getJgmc());
            }
        }
        return list;
    }

    private Zyxx zzdmConvert(Zyxx zyxx) {
        List<Zyxx> list = new ArrayList<Zyxx>();
        list.add(zyxx);
        return zddmConvert(list).get(0);
    }

    /**
     * 列表
     */
    @Override
    public PageView query(PageView pageView, Zyxx zyxx, DataTables dataTables, HttpServletRequest request) {
        HashMap<String, String> params = getSearchMap(dataTables, request);
        List<Zyxx> list = zddmConvert(zyxxDao.query(pageView, zyxx, params));
        pageView.setRecords(list);
        return pageView;
    }

    /**
     * 详情
     */
    @Override
    public Zyxx getById(String id) {
        try {
            return zzdmConvert(zyxxDao.getById(id));
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
    public Result update(Zyxx zyxx, Result result) {
        try {
            System.out.println("[zyxxdao]Zszymc=" + zyxx.getZszymc());
            zyxxDao.update(zyxx);
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
    public Result save(Zyxx zyxx, Result result) {
        try {
            zyxxDao.save(zyxx);
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
            zyxxDao.deleteByPrimaryKeys(ids);
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
    public List<Zyxx> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
        HashMap<String, String> params = getSearchMap(dataTables, request);
        List<Zyxx> list = zddmConvert(zyxxDao.query(params));
        return list;
    }

}

