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
    @Override
    public List<Authority> findAuthoritys(String ids) {
        return authorityMapper.selectByIds(ids);
    }

}
