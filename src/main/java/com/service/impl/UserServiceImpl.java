package com.service.impl;

import com.VO.UserVo;
import com.bean.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.UserMapper;
import com.service.UserService;
import com.service.UserService;
import com.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @create 2019/5/3了；
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override// 登录
    public User loginVerify(User user) {
        User us = userMapper.selectByEamil(user.getEmail());
        if (us != null) {
            if (user.getPassword().equals(us.getPassword())) {
                return us;
            }
        }
        return null;
    }

    @Override//修改密码
    public int updatePassByEmail(User user) {
        String pwd = MD5Utils.MD5(user.getEmail(),user.getPassword());
        user.setPassword(pwd);
        userMapper.updatePassByEmail(user);
        return 1;
    }

    @Override//获取验证码
    public int getVerify(String email){
       return EmailUtil.eamil(email);
    }

    @Override//添加用户
    public int insertUser(User user){
        String pwd = MD5Utils.MD5(user.getEmail(),user.getPassword());
        user.setPassword(pwd);
        if(userMapper.selectByEamil(user.getEmail()) != null){
            return 2;
        }else if(userMapper.insertSelective(user) > 0) {
            return 1;
        }
        return 0;
    }

    @Override//删除用户
    public int deleteByPrimary(Integer id) {
        return userMapper.deleteByPrimary(id);
    }

    @Override// 条件查询
    public Map<String,Object> findUsers(UserVo userVo) {
        PageInfo<User> pageInfo = PageHelper.startPage(userVo.getPage(), userVo.getLimit()).doSelectPageInfo(() -> userMapper.selectUsers(userVo));
        return LayuiUtil.data(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override// 批量删除
    public int deleteByIds(String ids) {
        return userMapper.deleteByIds(ids);
    }

    @Override// 通过email查询用户信息
    public User selectByEmail(String email) {
        return userMapper.selectByEamil(email);
    }
}
