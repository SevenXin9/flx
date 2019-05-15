package com.service.impl;

import com.bean.Authority;
import com.mapper.AuthorityMapper;
import com.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;
    @Override//查询权限
    public List<Authority> findAuthoritys(String ids) {
        return authorityMapper.selectByIds(ids);
    }

    @Override//获取全部权限
    public List<Authority> showAuthoritys(){
        return authorityMapper.selectByExample(null);
    }

}
