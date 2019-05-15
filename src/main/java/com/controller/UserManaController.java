package com.controller;

import com.VO.UserVo;
import com.bean.User;
import com.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserManaController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    // 进入用户管理界面
    @RequestMapping(value = "/intoUserMana", method = RequestMethod.GET)
    public String intoUserMana(){
        return "/admin/userMana/userMana";
    }

    // 进入添加用户界面
    @RequestMapping(value = "/intoAddUser", method = RequestMethod.GET)
    public String intoAddUser(){
        return "/admin/userMana/addUser";
    }

    /**
     * 删除用户
     * @return 是否删除成功
     */
    @RequestMapping(value = "/user/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresPermissions("user:delete")
    public boolean users(@PathVariable("ids") String ids ){
        int flag=userService.deleteByIds(ids);
        if (flag > 0){
            logger.info("成功删除编号为:"+ids+"的用户");
            return true;
        }
        logger.info("编号为:"+ids+"的用户，删除失败");
        return false;
    }

    /**
     * 条件查询用户
     * @param userVo 查询条件
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("user")
    public Map<String,Object> users(UserVo userVo){
        return userService.findUsers(userVo);
    }

    /**
     * 添加用户信息
     * @param user
     * @return 0:添加失败 1:添加成功 2:用户名已存在
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public int addUser(User user){
        return userService.insertUser(user);
    }

    
}
