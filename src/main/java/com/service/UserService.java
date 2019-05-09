package com.service;

import com.bean.User;

/**
 * @create 2019/5/3
 */
public interface UserService {
    /**
     * Email发送验证码
     * @param email
     * @return 验证码
     */
    public int getVerify(String email);

    /**
     * 添加用户
     * @param user 前台传过来的邮箱，密码
     */
    public void insertUser(User user);

    /**
     * 登录验证
     * @param user 前台传过来的账号，密码
     * @return 是否通过验证,通过返回User对象，不通过返回null
     */
    User loginVerify(User user);

    /**
     * 修改密码
     * @param user 前台传过来的邮箱，密码
     * @return 是否通过执行,通过返回User对象，不通过返回null
     */
    public int updatePassByEmail(User user);
}
