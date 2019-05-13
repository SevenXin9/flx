package com.service;

import com.VO.UserVo;
import com.bean.User;

import java.util.List;
import java.util.Map;

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
    public Boolean insertUser(User user);

    /**
     * 登录验证
     * @param user 前台传过来的账号，密码
     * @return 是否通过验证,通过返回User对象，不通过返回null
     */
    public User loginVerify(User user);

    /**
     * 修改密码
     * @param user 前台传过来的邮箱，密码
     * @return 是否通过执行,通过返回User对象，不通过返回null
     */
    public int updatePassByEmail(User user);

    /**
     * 删除用户
     * @param id 通过id删除用户
     */
    public int deleteByPrimary(Integer id);

    /**
     * 条件查询所有用户
     * @param userVo
     * @return
     */
    public Map<String,Object> findUsers(UserVo userVo);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteByIds(String ids);

    /**
     * 通过email查询用户信息
     * @param email
     * @return
     */
    public User selectByEmail(String email);

}
