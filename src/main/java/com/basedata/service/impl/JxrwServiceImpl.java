package com.basedata.service.impl;

import com.basedata.dao.IJxrwDao;
import com.basedata.model.Jxrw;
import com.basedata.model.Jxrw;
import com.basedata.service.IJxrwService;
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
import java.util.HashMap;
import java.util.List;

@Service
public class JxrwServiceImpl implements IJxrwService {

    @Autowired
    private IJxrwDao jxrwDao;

    /**
     * 列表
     */
    @Override
    public PageView query(PageView pageView, Jxrw Jxrw, DataTables dataTables, HttpServletRequest request) {
        return pageView;
    }

    /**
     * 详情
     */
    @Override
    public Jxrw getById(String id) {
        return null;
    }

    /**
     * 更新
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result update(Jxrw jxrw, Result result) {
        return result;
    }

    /**
     * 添加
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result save(Jxrw jxrw, Result result) {
        return result;
    }

    /**
     * 删除
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result delByIds(List<Integer> ids, Result result) {
        return result;
    }

    /**
     * 筛选所有的班级
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public List<Jxrw> getClazz() {
        return jxrwDao.getClazz();
    }

}
