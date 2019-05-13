package com.controller;

import com.bean.Admin;
import com.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


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
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(HttpSession session){
        return "/admin/index";
    }

    // 进入修改密码界面
    @RequestMapping(value = "intoEditUserPWD",method = RequestMethod.GET)
    public String intoEditUserPWD(){
        return "/admin/editPWD/editPWD";
    }

    // 进入角色管理界面
    @RequestMapping(value = "intoRoleMana", method = RequestMethod.GET)
    public String intoRoleMana(){
        return "/admin/roleMana/roleMana";
    }

    // 进入角色添加界面
    @RequestMapping(value = "intoAddRole", method = RequestMethod.GET)
    public String intoAddRole(){
        return "/admin/roleMana/addRole";
    }

    // 进入修改角色界面
    @RequestMapping(value = "intoEditRole", method = RequestMethod.GET)
    public String intoEditRole(){
        return "/admin/roleMana/editRole";
    }

    // 进入角色授权界面
    @RequestMapping(value = "intoGrantRole", method = RequestMethod.GET)
    public String intoGrantRole(){
        return "/admin/roleMana/grantRole";
    }

    // 进入管理员管理界面
    @RequestMapping(value = "intoAdminMana", method = RequestMethod.GET)
    public String intoAdmin(){
        return "/admin/adminMana/adminMana";
    }

    // 进入添加管理员界面
    @RequestMapping(value = "intoAddAdmin", method = RequestMethod.GET)
    public String intoAddAdmin(){
        return "/admin/adminMana/addAdmin";
    }

    // 进入修改管理员界面
    @RequestMapping(value = "intoEditAdmin", method = RequestMethod.GET)
    public String intoEditAdmin(){
        return "/admin/adminMana/editAdmin";
    }
}
