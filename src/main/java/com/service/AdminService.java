package com.service;

import com.bean.Admin;

/**
 * @create 2019/5/9
 */
public interface AdminService {

    /**
     * 通过用户名名获取admin对象
     * @param  admin1 用户名
     * @return admin对象
     */
    boolean selectByNamePass(Admin admin1);
}
