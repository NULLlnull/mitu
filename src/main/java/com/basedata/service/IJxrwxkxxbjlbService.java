package com.basedata.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.basedata.vo.DataTables;
import com.basedata.model.Jxrwxkxxbjlb;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

public interface IJxrwxkxxbjlbService {

    /**
     * 列表
     */
    public PageView query(PageView pageView, Jxrwxkxxbjlb jxrwxkxxbjlb, DataTables dataTables, HttpServletRequest request);

    /**
     * 详情
     */
    public Jxrwxkxxbjlb getById(String id);

    /**
     * 更新
     */
    public Result update(Jxrwxkxxbjlb jxrwxkxxbjlb, Result result);

    /**
     * 添加
     */
    public Result save(Jxrwxkxxbjlb jxrwxkxxbjlb, Result result);

    /**
     * 删除
     */
    public Result delByIds(List<Integer> ids, Result result);

    /**
     * 导出
     */
    public List<Jxrwxkxxbjlb> exportData(DataTables dataTables, HttpServletRequest request) throws Exception;

}

