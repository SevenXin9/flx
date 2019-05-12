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
}
