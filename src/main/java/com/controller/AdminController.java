package com.controller;

import com.bean.Admin;
import com.bean.User;
import com.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @create 2019/5/9
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String tologin(){
        return "admin/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean login(Admin admin){
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(admin.getName(),admin.getPassword()));
        }catch (IncorrectCredentialsException e) {
           return false;
        }catch (UnknownAccountException e) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "admin/index";
    }
}