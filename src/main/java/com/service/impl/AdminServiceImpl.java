package com.service.impl;

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

    @Override//通过ids删除管理员
    public int deleteByPrimaryKey(String manageIds) {
        return adminMapper.deleteByPrimaryKey(manageIds);
    }

    @Override//修改管理员
    public int updateByPrimaryKeySelective(Admin admin) {
        if (adminMapper.selectByNamePass(admin.getName())!=null){//用户名重复
            return 0;
        }
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override//添加管理员
    public int insert(Admin admin) {
        if (adminMapper.selectByNamePass(admin.getName())!=null){//用户名重复
            return 0;
        }
        return insert(admin);
    }

    @Override//通过id获取管理员
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
