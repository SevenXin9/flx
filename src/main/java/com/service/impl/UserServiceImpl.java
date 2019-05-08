package com.service.impl;

import com.bean.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.service.UserService;
import com.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 封颖鹏
 * @create 2019/5/3
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginVerify(User user) {
        User us = userMapper.selectByEamil(user.getEmail());
        if (us != null) {
            if (user.getPassword().equals(us.getPassword())) {
                return us;
            }
        }
        return null;
    }

    //修改密码
    public int updatePassByEmail(User user) {
        user.setPassword(MD5Utils.MD5(user.getEmail(),user.getPassword()));
        return userMapper.updatePassByEmail(user);
    }

    //获取验证码
    public int getVerify(String email){
       return EmailUtil.eamil(email);
    }

    //添加用户
    public void insertUser(User user){
        String pwd = MD5Utils.MD5(user.getEmail(),user.getPassword());
        user.setPassword(pwd);
        userMapper.insertSelective(user);
    }
}
