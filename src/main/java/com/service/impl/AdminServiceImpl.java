package com.service.impl;

import com.VO.AdminVo;
import com.VO.CarPictureTypeBrandVO;
import com.bean.Admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.utils.LayuiUtil;
import com.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public Map<String,Object>  selectAll(AdminVo adminVo){
        PageInfo<AdminVo> pageInfo = PageHelper.startPage(adminVo.getPage(), adminVo.getLimit()).doSelectPageInfo(() -> adminMapper.selectAdmin(adminVo));
        return LayuiUtil.data(pageInfo.getTotal(),pageInfo.getList());
    }

}
