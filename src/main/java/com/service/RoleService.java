package com.service;

import com.VO.RoleVo;
import com.bean.Admin;
import com.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    /**
     * 条件查询所有角色信息
     * @param roleVo
     * @return
     */
    Map<String, Object> findRoles(RoleVo roleVo);

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    Role findRole(Integer id);

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
     * 添加用户权限
     * @param roleId
     * @param authority
     */
    public void addAuthority(Integer roleId,String authority);

    /**
     * 删除用户权限
     * @param roleId
     * @param authority
     */
    public void delAuthority(Integer roleId,String authority);
}
