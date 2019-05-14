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
     * 删除管理员
     * @param manageIds 管理员的ids
     * @return
     */
    Boolean deleteByPrimaryKey(String manageIds);

    /**
     * 修改管理员
     * @param admin
     * @return 0:修改失败 1:修改成功 2:用户名已存在
     */
    int updateByPrimaryKeySelective(Admin admin);

    /**
     * 添加管理员
     * @param admin
     * @return 0:添加失败 1:添加成功 2:用户名已存在
     */
    int insert(Admin admin);

    /**
     * 通过id获取管理员
     * @param id
     * @return
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     * 条件查询管理员信息
     * @param adminVo
     * @return
     */
    Map<String, Object> selectAll(AdminVo adminVo);
}
