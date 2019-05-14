package com.service;

import com.bean.Authority;

import java.util.List;

public interface AuthorityService {
    public List<Authority> findAuthoritys(String ids);
}
