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

import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper rolemapper;

    @Override
    public Map<String, Object> findRoles(RoleVo roleVo) {
        PageInfo<Role> pageInfo = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit()).doSelectPageInfo(() -> rolemapper.selectRoles(roleVo));
        return LayuiUtil.data(pageInfo.getTotal(),pageInfo.getList());
    }

    //根据id查询角色
    @Override
    public Role findRole(Integer id) {
        return rolemapper.selectByPrimaryKey(id);
    }

}
