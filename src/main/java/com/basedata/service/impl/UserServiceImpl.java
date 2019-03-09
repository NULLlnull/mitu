package com.basedata.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.basedata.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.basedata.dao.IMenuDao;
import com.basedata.dao.IPrivilegeDao;
import com.basedata.dao.IRyjcxxDao;
import com.basedata.dao.IUserDao;
import com.basedata.model.Menu;
import com.basedata.model.Privilege;
import com.basedata.model.Ryjcxx;
import com.basedata.model.User;
import com.basedata.service.IUserService;
import com.basedata.utils.MD5Utils;
import com.basedata.utils.SessionUtils;
import com.basedata.vo.DataTables;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRyjcxxDao ryjcxxDao;

    @Autowired
    private IPrivilegeDao privilegeDao;

    @Autowired
    private IMenuDao menuDao;

    /**
     * 列表
     */
    @Override
    public PageView query(PageView pageView, User User, DataTables dataTables, HttpServletRequest request) {
        StringBuffer subSql = new StringBuffer(" ");
        if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
            // subSql.append(" and xxxId =
            // ").append(request.getParameter("xxxId"));
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition", dataTables.getSearch());
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        List<User> list = userDao.query(pageView, User, params);
        pageView.setRecords(list);
        return pageView;
    }

    /**
     * 详情
     */
    @Override
    public User getById(String id) {
        try {
            return userDao.getById(id);
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
    public Result update(User user, Result result) {
        try {
            userDao.update(user);
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
    public Result save(User user, Result result) {
        try {
            userDao.save(user);
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
            userDao.deleteByPrimaryKeys(ids);
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
    public List<User> exportData(DataTables dataTables, HttpServletRequest request) throws Exception {
        StringBuffer subSql = new StringBuffer(" ");
        if (!StringUtils.isEmpty(request.getParameter("xxxId"))) {
            // subSql.append(" and xxxId =
            // ").append(request.getParameter("xxxId"));
        }
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("condition",
                URLDecoder.decode(dataTables.getSearch() != null ? dataTables.getSearch() : "", "UTF-8"));
        params.put("subSql", subSql.toString().replaceFirst("and ", "").trim());
        List<User> Users = userDao.query(params);
        return Users;
    }

    /**
     * 用户登录
     */
    @Override
    public Result login(String username, String password) {
        Result result = new Result();
        result.setStatus(-1);
        try {
            User user = userDao.queryByName(username);
            if (user != null) {
                if (MD5Utils.encodeMD5(password).equals(user.getPassword())) {
                    result.setData(user);
                    result.setStatus(0);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 本地用户登录
     */
    @Override
    public Result userLogin(HttpServletRequest request, String username, String password) {
        Result result = new Result(-1);
        try {
            User user = userDao.queryByName(username);
            if (user == null) {
                return result;
            }
            if (!MD5Utils.encodeMD5(password).equals(user.getPassword())) {
                return result;
            }
            // 1为教师，2为学生
            if (user.getType() == 1 && user.getFk() != null) {
                Ryjcxx ryjcxx = ryjcxxDao.getById(String.valueOf(user.getFk()));
                if (ryjcxx != null) {
                    SessionUtils.setRyjcxx(request, ryjcxx);
                    SessionUtils.setUser(request, user);
                    result.setStatus(0);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 用户菜单
     */
    @Override
    public List<Menu> getMenus(User user, HttpServletRequest request) {
        List<Menu> m_list = new ArrayList<Menu>();
        try {
            if (user != null) {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("subSql", "roleId = '" + user.getRoleId() + "'");
                List<Privilege> p_list = privilegeDao.query(params);

                if (p_list == null || p_list.size() == 0) {
                    return m_list;
                }
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < p_list.size(); i++) {
                    if (i == 0) {
                        sb.append("(");
                    }
                    if (i != p_list.size() - 1) {
                        sb.append(p_list.get(i).getMenuId()).append(",");
                    } else {
                        sb.append(p_list.get(i).getMenuId()).append(")");
                    }
                }
                String subSql = "id in " + sb.toString() + " and sysId = '1'";
                HashMap<String, String> menuParams = new HashMap<String, String>();
                menuParams.put("subSql", subSql);
                m_list = menuDao.query(menuParams);
                if (m_list != null && m_list.size() > 0) {
                    Map<String, Boolean> privilege = new HashMap<String, Boolean>();
                    for (Menu m : m_list) {
                        for (Privilege p : p_list) {
                            if (p.getMenuId().equals(m.getId() + "")) {
                                privilege.put(m.getId() + ":add", "true".equals(p.getAddFlag()) ? true : false);
                                privilege.put(m.getId() + ":del", "true".equals(p.getDeleteFlag()) ? true : false);
                                privilege.put(m.getId() + ":update", "true".equals(p.getUpdateFlag()) ? true : false);
                                privilege.put(m.getId() + ":select", "true".equals(p.getSelectFlag()) ? true : false);
                            }
                        }
                    }
                    SessionUtils.setPrivilege(request, privilege);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m_list;
    }

}
