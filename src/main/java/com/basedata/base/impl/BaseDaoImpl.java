package com.basedata.base.impl;

import com.basedata.base.BaseDao;
import com.basedata.vo.PageView;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合持久层的公用的增，删，改，查
 *
 * @param <T>
 * @author Administrator
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 获取传过来的泛型类名
     *
     * @return
     */
    public String getClassName() {
        // 在父类中得到子类声明的父类的泛型信息
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class) pt.getActualTypeArguments()[0];
        // 这里是获取实体类的简单名称，再把类名转为小写
        return clazz.getSimpleName().toString().toLowerCase();
    }

    public List<T> query(PageView pageView, T t) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", t);
        return getSqlSession().selectList(this.getClassName() + ".query", map);
    }

    public List<T> query(HashMap<String, String> params) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("params", params);
        return getSqlSession().selectList(this.getClassName() + ".queryByParams", map);
    }

    public T queryOne(HashMap<String, String> params) {
        List<T> list = query(params);
        if (list == null || list.size() == 0)
            return null;
        return list.get(0);
    }

    public List<T> query(PageView pageView, T t, HashMap<String, String> params) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", t);
        map.put("params", params);
        return getSqlSession().selectList(this.getClassName() + ".queryByParams", map);
    }

    public List<T> queryAll(T t) {
        return getSqlSession().selectList(this.getClassName() + ".queryAll", t);
    }

    public void delete(String id) {
        getSqlSession().delete(this.getClassName() + ".deleteById", id);
    }

    public int deleteByPrimaryKeys(List<Integer> idlist) {
        return getSqlSession().delete(this.getClassName() + ".deleteByPrimaryKeys", idlist);
    }

    public void update(T t) {
        getSqlSession().update(this.getClassName() + ".update", t);
    }

    @SuppressWarnings("unchecked")
    public T getById(String id) {
        return (T) getSqlSession().selectOne(this.getClassName() + ".getById", id);
    }

    @Override
    public void save(T t) {
        getSqlSession().insert(this.getClassName() + ".save", t);
    }
}
