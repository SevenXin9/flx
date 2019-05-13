package com.service;

import com.bean.Admin;

/**
 * @create 2019/5/9
 */
public interface AdminService {

    /**
     * 通过用户名获取admin对象
     * @param  name 用户名
     * @return admin对象
     */
    Admin selectByName(String name);

    /**
     * 删除管理员
     * @param manageIds 管理员的ids
     * @return
     */
    int deleteByPrimaryKey(String manageIds);

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    int updateByPrimaryKeySelective(Admin admin);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    int insert(Admin admin);

    /**
     * 通过id获取管理员
     * @param id
     * @return
     */
    Admin selectByPrimaryKey(Integer id);
}
