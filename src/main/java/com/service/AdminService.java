package com.service;

import com.VO.AdminVo;
import com.bean.Admin;

import java.util.List;
import java.util.Map;

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
     * 条件查询管理员信息
     * @param adminVo
     * @return
     */
    Map<String,Object>  selectAll(AdminVo adminVo);

}
