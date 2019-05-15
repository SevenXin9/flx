package com.service;

import com.VO.RoleVo;
import com.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * @create 2019/5/13
 */
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
     * 添加角色
     * @param role
     * @return
     */
    public int insert(Role role);

    /**
     * 修改角色
     * @return
     */
    public int updataRole(Role role);

    /**
     * 删除角色(可多删)
     * @param roleIds
     * @return
     */
    public  int delRole(String roleIds);

    /**
     * 添加角色权限
     * @param roleId
     * @param authority
     */
    public void addAuthority(Integer roleId,String authority);

    /**
     * 删除角色权限
     * @param roleId
     * @param authority
     */
    public void delAuthority(Integer roleId,String authority);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> selectByAll();
}
