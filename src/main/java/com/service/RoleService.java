package com.service;

import com.bean.Role;

import java.util.List;

/**
 * @create 2019/5/13
 */
public interface RoleService {

    /**
     * 添加权限
     * @param role
     * @return
     */
    public int insert(Role role);

    /**
     * 修改权限
     * @return
     */
    public int updataRole(Role role);

    /**
     * 删除权限(可多删)
     * @param roleIds
     * @return
     */
    public  int delRole(String roleIds);

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> selectByAll();
}
