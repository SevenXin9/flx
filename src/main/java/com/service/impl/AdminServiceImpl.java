package com.service.impl;

import com.VO.AdminVo;
import com.bean.Admin;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //条件查询管理员信息
    @Override
    public List<AdminVo> selectAll(AdminVo adminVo){return adminMapper.selectAdmin(adminVo);}
}
