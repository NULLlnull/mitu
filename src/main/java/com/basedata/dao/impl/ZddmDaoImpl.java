package com.basedata.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.basedata.base.impl.BaseDaoImpl;
import com.basedata.dao.IZddmDao;
import com.basedata.model.Zddm;

@Repository
public class ZddmDaoImpl extends BaseDaoImpl<Zddm> implements IZddmDao {

    /**
     * 获取字典类别数据
     */
    @Override
    public List<Zddm> property(String zdlb) {
        List<Zddm> list = getSqlSession().selectList(this.getClassName() + ".queryByZdlb", zdlb);
//        System.out.println("[zddmdao.property]zdlb=" + zdlb);
//        System.out.println("[zddmdao.property]list=" + list.size());
        return list;
    }

}
