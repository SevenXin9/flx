package com.service.impl;

import com.bean.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.service.UserService;
import com.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @create 2019/5/3
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginVerify(User user) {
        System.out.println("aaa");
        User us = userMapper.selectByEamil(user.getEmail());
        if (us != null) {
            if (user.getPassword().equals(us.getPassword())) {
                return us;
            }
        }
        return null;
    }

    //获取验证码
    public int getVerify(String email){
       return EmailUtil.eamil(email);
    }

    //添加用户
    public void insertUser(User user){
        System.out.println("进来了");
        String pwd = MD5Utils.MD5(user.getEmail(),user.getPassword());
        user.setPassword(pwd);
        System.out.println(userMapper.insertSelective(user));
    }
}
