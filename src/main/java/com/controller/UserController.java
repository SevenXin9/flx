package com.controller;

import com.VO.CarPictureVO;
import com.bean.Address;
import com.bean.User;
import com.service.AddressService;
import com.service.CarService;
import com.service.UserService;
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

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private AddressService addressService;


    @RequestMapping("/index")
    public String index(Model model){
        // 获取省级城市信息
        List<Address> addresses = addressService.getAddressesByParentId(-1);
        // 获取新车发行的车
        List<CarPictureVO> Cars=carService.selectCarPicture1();
        model.addAttribute("addresses", addresses);
        model.addAttribute("Cars",Cars);
        return "index";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean userLogin(User user, HttpSession session){
        user.setPassword(MD5Utils.MD5(user.getEmail(),user.getPassword()));
        User us = userService.loginVerify(user);
        if(us!=null){
            session.setAttribute("user",us);
            return true;
        }
        return false;
    }


    //传输注册验证码
    @RequestMapping(value = "/Verify")
    @ResponseBody
    public void getVerify(@RequestParam("email") String email, HttpSession session){
        System.out.println("shuchu "+email);
        String value=userService.getVerify(email)+"";
        System.out.println("验证码是："+value+"==================================");
        session.setAttribute("verify",value);//保存验证码
    }

    @RequestMapping(value = "/regest")
    @ResponseBody
    public String regest(User user,@RequestParam("name") String verify2,HttpSession session){
        System.out.println("添加用户"+session.getAttribute("verify")+"    "+verify2);
        System.out.println(user.getEmail()+"          "+user.getPassword());
        if (session.getAttribute("verify").equals(verify2)){
            session.removeAttribute("verify");
            System.out.println("ok");
            userService.insertUser(user);//添加用户
            return "ok";
        }
        System.out.println("no");
        return "no";
    }

}
