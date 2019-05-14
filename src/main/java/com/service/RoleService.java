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
}