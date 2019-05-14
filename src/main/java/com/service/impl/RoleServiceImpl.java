package com.service.impl;

import com.bean.Role;
import com.mapper.RoleMapper;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @create 2019/5/13
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override//添加权限
    public int insert(Role role) {
        if (roleMapper.selectByName(role.getRolename())!=null){
            return 0;
        }
        return roleMapper.insert(role);
    }

    @Override//修改权限
    public int updataRole(Role role) {
        if (roleMapper.selectByName(role.getRolename())!=null){
            return 0;
        }
        return roleMapper.updateByPrimaryKeyWithBLOBs(role);
    }

    @Override//删除权限
    public int delRole(String roleIds) {
        return roleMapper.deleteByPrimaryKey(roleIds);
    }
}
