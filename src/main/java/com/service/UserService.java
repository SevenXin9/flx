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

    /**
     * 登录验证
     * @param user 前台传过来的账号，密码
     * @return 是否通过验证,通过返回User对象，不通过返回null
     */
    User loginVerify(User user);
}
