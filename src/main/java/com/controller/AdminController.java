package com.controller;

import com.bean.Admin;
import com.bean.Role;
import com.service.AdminService;
import com.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;


/**
 * @create 2019/5/9
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String tologin(){
        return "admin/login";
    }

    // 管理员登录
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
        subject.getSession().setAttribute("admin", admin);
        return true;
    }

    // 进入首页
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpSession session){
        return "/admin/index";
    }

    // 进入修改密码界面
    @RequestMapping(value = "/intoEditUserPWD",method = RequestMethod.GET)
    public String intoEditUserPWD(){
        return "/admin/editPWD/editPWD";
    }

    // 退出登录
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/admin/login";
    }

}
