package com.controller;

import com.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","这是首页");
        return "index";
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public void userLogin(User user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (UnknownAccountException  uae) {
            System.out.println("用户名和密码不匹配");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("用户名和密码不匹配");
        }
    }
}
