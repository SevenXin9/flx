package com.service.impl;

import com.bean.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {

    }

    @Override
    public User loginVerify(User user) {
        System.out.println("aaa");
        User us = userMapper.selectByEamil(user.getEmail());
        if(us!=null){
            if(user.getPassword().equals(us.getPassword())){
                return us;
            }
        }
        return null;
    }
}
