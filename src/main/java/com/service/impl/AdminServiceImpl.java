package com.service.impl;

import com.VO.AdminVo;
import com.bean.Admin;
import com.controller.IndexController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.utils.LayuiUtil;
import com.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @create 2019/5/9
 */
@Service
public class AdminServiceImpl implements AdminService {

    //日志
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
   private AdminMapper adminMapper;

    @Override//通过name获取admin
    public Admin selectByName(String name) {
      return adminMapper.selectByNamePass(name);
    }

    @Override//条件查询管理员信息
    public Map<String, Object> selectAll(AdminVo adminVo){
        PageInfo<AdminVo> pageInfo = PageHelper.startPage(adminVo.getPage(), adminVo.getLimit()).doSelectPageInfo(() -> adminMapper.selectAdmin(adminVo));
        return LayuiUtil.data(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override//通过ids删除管理员
    public Boolean deleteByPrimaryKey(String manageIds) {
        if(adminMapper.deleteByPrimaryKey(manageIds) > 0){
            logger.info("成功删除编号为:"+manageIds+"里的管理员");
            return true;
        }
        logger.info("管理员编号为:"+manageIds+"删除失败");
        return false;
    }

    @Override//修改管理员
    public int updateByPrimaryKeySelective(Admin admin) {
        admin.setPassword(MD5Utils.MD5(admin.getName(), admin.getPassword()));
        if (adminMapper.selectByNamePass(admin.getName())!=null){//用户名重复
            return 2;
        }else if(adminMapper.updateByPrimaryKeySelective(admin) > 0){
            logger.info("编号为:"+admin.getId()+"的管理员修改成功");
            return 1;
        }
        logger.info("编号为:"+admin.getId()+"的管理员修改失败");
        return 0;
    }

    @Override//添加管理员
    public int insert(Admin admin) {
        admin.setPassword(MD5Utils.MD5(admin.getName(), admin.getPassword()));
        if (adminMapper.selectByNamePass(admin.getName())!=null){//用户名重复
            return 2;
        }else if(adminMapper.insertSelective(admin) > 0){
            logger.info(admin.getName()+"管理员添加成功");
            return 1;
        }
        logger.info(admin.getName()+"管理员添加失败");
        return 0;
    }

    @Override//通过id获取管理员
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
