package com.controller;

import com.VO.CarPictureVO;
import com.bean.*;
import com.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.bean.Address;
import com.bean.Address;
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
            logger.info("用户"+user.getEmail()+"成功登录");
            return true;
        }
        //账号密码错误，返回false
        logger.info("用户"+user.getEmail()+"登陆失败");
        return false;
    }


    //传输注册验证码
    @RequestMapping(value = "/Verify",method = RequestMethod.POST)
    @ResponseBody
    public void getVerify(@RequestParam("email") String email, HttpSession session){
        System.out.println("shuchu "+email);
        String value=userService.getVerify(email)+"";
        System.out.println("验证码是："+value+"==================================");
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
        System.out.println(user.getEmail()+"          "+user.getPassword());
        if (session.getAttribute("verify").equals(verify2)){//比较验证码
            session.removeAttribute("verify");
            userService.insertUser(user);//添加用户
            logger.info("用户"+user.getEmail()+"成功注册");
            return "ok";
        }
        logger.info("用户"+user.getEmail()+"注册失败");
        return "no";
    }

    /**
     * 退出登录
     * @return 客户端跳转至首页
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        User user = (User) session.getAttribute("user");
        //清除session
        session.removeAttribute("user");
        logger.info("用户"+user.getEmail()+"退出登录了");
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
            logger.info("成功修改了email为:"+user.getEmail()+"用户的密码");
            return true;
        }
        logger.info("修改email为:"+user.getEmail()+"用户的密码失败");
        return false;
    }


    /**
     * 删除用户
     * @return 是否删除成功
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@PathVariable("id") Integer id ){
        int flag=userService.deleteByPrimary(id);
        if (flag ==1){
            logger.info("成功删除编号为:"+id+"的用户");
            return true;
        }
        logger.info("编号为:"+id+"的用户，删除失败");
        return false;
    }

}
