package com.service.impl;

import com.VO.CarPictureTypeBrandVO;
import com.VO.RoleVo;
import com.bean.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.RoleMapper;
import com.service.RoleService;
import com.utils.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Map<String, Object> findRoles(RoleVo roleVo) {
        PageInfo<Role> pageInfo = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit()).doSelectPageInfo(() -> roleMapper.selectRoles(roleVo));
        return LayuiUtil.data(pageInfo.getTotal(),pageInfo.getList());
    }

    //根据id查询角色
    @Override
    public Role findRole(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override//添加角色
    public int insert(Role role) {
        if (roleMapper.selectByName(role.getRolename())!=null){
            return 0;
        }
        return roleMapper.insert(role);
    }

    @Override//修改角色
    public int updataRole(Role role) {
        if (roleMapper.selectByName(role.getRolename())!=null){
            return 0;
        }
        return roleMapper.updateByPrimaryKeyWithBLOBs(role);
    }


    @Override//删除角色
    public int delRole(String roleIds) {
        return roleMapper.deleteByPrimaryKey(roleIds);
    }

    @Override
    public void addAuthority(Integer roleId,String authority){
        Role role= roleMapper.selectByPrimaryKey(roleId);
        String auth = role.getAuthority();
        if(auth!=null) {
            auth+=","+authority;
        }else {
            auth=authority;
        }
        role.setAuthority(auth);
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void delAuthority(Integer roleId,String authority) {
        Role role= roleMapper.selectByPrimaryKey(roleId);
        String auth[] = role.getAuthority().split(",");
        List<String> list = new ArrayList<String>();
        for (String a:auth) {
            if(!a.equals(authority)) {
                list.add(a);
            }
        }
        role.setAuthority(StringUtils.join(list.toArray(), ","));
        roleMapper.updateByPrimaryKeySelective(role);
    }
}
