package com.service;

import com.bean.User;

/**
 * 封颖鹏
 * @create 2019/5/3
 */
public interface UserService {
    //获取验证码
    public int getVerify(String email);

    //添加用户
    public void insertUser(User user);
}
