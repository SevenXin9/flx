package com.service.impl;

import com.bean.Admin;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @create 2019/5/9
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
   private AdminMapper adminMapper;

    @Override//通过name获取admin
    public Admin selectByName(String name) {
      return adminMapper.selectByNamePass(name);
    }
}
