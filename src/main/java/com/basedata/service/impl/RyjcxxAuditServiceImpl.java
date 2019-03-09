package com.basedata.service.impl;

import com.basedata.dao.IRyjcxxAuditDao;
import com.basedata.dao.IRyjcxxDao;
import com.basedata.model.Ryjcxx;
import com.basedata.model.RyjcxxAudit;
import com.basedata.service.IRyjcxxAuditService;
import com.basedata.vo.DataTables;
import com.basedata.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class RyjcxxAuditServiceImpl implements IRyjcxxAuditService {

    @Autowired
    private IRyjcxxAuditDao ryjcxxAuditDao;

    @Autowired
    private IRyjcxxDao ryjcxxDao;

    /**
     * 添加记录
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result save(RyjcxxAudit ryjcxxAudit, Result result) {
        try {
            Date now = new Date();
            ryjcxxAudit.setAudit_time(now);
            ryjcxxAuditDao.save(ryjcxxAudit);
            Ryjcxx ryjxcc = ryjcxxDao.getById(ryjcxxAudit.getTeacherId());
            ryjxcc.setAudit_status(ryjcxxAudit.getAudit_status());
            ryjxcc.setAuditor(ryjcxxAudit.getAuditor());
            ryjxcc.setAudit_time(now);
            ryjcxxDao.update(ryjxcc);
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
    public List<RyjcxxAudit> exportData(RyjcxxAudit ryjcxxAudit, DataTables dataTables, HttpServletRequest request) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition", ryjcxxAudit.getTeacherId() + "");
        List<RyjcxxAudit> list = ryjcxxAuditDao.query(params);
        return list;
    }

}
