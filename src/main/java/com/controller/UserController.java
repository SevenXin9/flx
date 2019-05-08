package com.controller;

import com.VO.CarPictureVO;
import com.bean.*;
import com.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.bean.Address;
import com.bean.Address;
import com.service.CarService;
import com.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * 登录
     * @param user 客户端输入的用户密码
     * @param session 获得HttpSession
     * @return 登录成功返回true，登录失败返回false
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean userLogin(User user, HttpSession session){
        //将前台输入的密码加密已便于与正确密码比对
        user.setPassword(MD5Utils.MD5(user.getEmail(),user.getPassword()));
        //调用业务层验证账号密码是否正确
        User us = userService.loginVerify(user);
        if(us!=null){
            //账号密码正确，添加至session
            session.setAttribute("user",us);
            return true;
        }
        //账号密码错误，返回false
        return false;
    }


    //传输注册验证码
    @RequestMapping(value = "/Verify",method = RequestMethod.POST)
    @ResponseBody
    public void getVerify(@RequestParam("email") String email, HttpSession session){
        String value=userService.getVerify(email)+"";
        session.setAttribute("verify",value);//保存验证码
    }

    /**
     * 注册
     * @param user
     * @param verify2
     * @param session
     * @return
     */
    @RequestMapping(value = "/regest",method = RequestMethod.POST)
    @ResponseBody
    public String regest(User user,@RequestParam("name") String verify2,HttpSession session){
        if (session.getAttribute("verify").equals(verify2)){//比较验证码
            session.removeAttribute("verify");
            userService.insertUser(user);//添加用户
            return "ok";
        }
        return "no";
    }

    /**
     * 退出登录
     * @return 客户端跳转至首页
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        //清除session
        session.removeAttribute("user");
        return "redirect:index";
    }

    /**
     * 修改密码
     * @return 是否修改成功
     */
    @RequestMapping(value = "/forgetPassword",method = RequestMethod.PUT)
    @ResponseBody
    public Boolean forgetPassword(User user,@RequestParam("verify") String verify2,HttpSession session){
        if (session.getAttribute("verify").equals(verify2)){//比较验证码
            session.removeAttribute("verify");
            userService.updatePassByEmail(user);
            return true;
        }return false;
    }
}
