package com.basedata.base;

import java.util.HashMap;
import java.util.List;

import com.basedata.vo.PageView;

/**
 * 集合持久层的公用的增，删，改，查接口
 *
 * @param <T>
 * @author Administrator
 */
public interface BaseDao<T> {
    /**
     * 返回分页后的数据
     *
     * @param pageView
     * @param t
     * @return
     */
    public List<T> query(PageView pageView, T t);

    /**
     * 按照查询条件进行查询
     *
     * @param params
     * @return
     */
    public List<T> query(HashMap<String, String> params);

    /**
     * 按照查询条件进行分页
     *
     * @param pageView
     * @param t
     * @param params
     * @return
     */
    public List<T> query(PageView pageView, T t, HashMap<String, String> params);

    /**
     * 按照查询条件获取第一条记录
     */
    public T queryOne(HashMap<String, String> params);

    /**
     * 返回所有数据
     *
     * @param t
     * @return
     */
    public List<T> queryAll(T t);

    /**
     * 根据iD删除数据
     *
     * @param id
     */
    public void delete(String id);

    /**
     * 根据id批量删除
     *
     * @param idlist
     * @return
     */
    int deleteByPrimaryKeys(List<Integer> idlist);

    /**
     * 修改实体
     *
     * @param t
     */
    public void update(T t);

    /**
     * 根据ID获取实体对象
     *
     * @param id
     * @return
     */
    public T getById(String id);

    /**
     * 添加一个实体对象
     *
     * @param t
     */
    public void save(T t);
}
