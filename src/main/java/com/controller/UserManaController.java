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

    /**
     * 删除用户
     * @return 是否删除成功
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresPermissions("user:delete")
    public boolean users(@PathVariable("id") Integer id ){
        int flag=userService.deleteByPrimary(id);
        if (flag ==1){
            logger.info("成功删除编号为:"+id+"的用户");
            return true;
        }
        logger.info("编号为:"+id+"的用户，删除失败");
        return false;
    }

    /**
     * 条件查询用户
     * @param userVo 查询条件
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("user:select")
    public Map<String,Object> users(UserVo userVo){
        return userService.findUsers(userVo);
    }
}
