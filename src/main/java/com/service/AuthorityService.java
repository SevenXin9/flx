package com.service;

import com.bean.Authority;

import java.util.List;

public interface AuthorityService {
    /**
     * 查询权限
     * @param ids
     * @return
     */
    public List<Authority> findAuthoritys(String ids);

    /**
     * 获取全部权限
     * @return
     */
    public List<Authority> showAuthoritys();


}
