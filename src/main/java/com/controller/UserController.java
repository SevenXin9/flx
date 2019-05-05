package com.controller;

import com.bean.Address;
import com.bean.User;
import com.service.AddressService;
import com.service.UserService;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","这是首页");
        return "index";
    }


    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public boolean userLogin(User user, HttpSession session){
        User us = userService.loginVerify(user);
        if(us!=null){
            session.setAttribute("user",us);
            return true;
        }
        return false;
    }


    @Autowired
    private AddressService addressService;

    // 获取县级城市信息
    @RequestMapping(value = "/getCounty", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getCounty(Model model, @RequestParam(value = "parentid", defaultValue = "0") Integer parentid){
        return addressService.getAddressesByParentId(parentid);
    }

//    @RequestMapping(value = "/intoInsert", method = RequestMethod.GET)
//    public String intoInsert(Model model){
//        User user = new User();
//        user.setEmail("123");
//        user.setPassword("123");
//        System.out.println(user);
//        userService.insert(user);
//        return "index";
//    }
}
