package com.controller;

import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.bean.Address;
import com.bean.User;
import com.service.AddressService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import com.service.*;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model){
        // 获取省级城市信息
        List<Address> addresses = addressService.getAddressesByParentId(-1);
        model.addAttribute("addresses", addresses);
        return "index";
    }

    // 获取县级城市信息
    @RequestMapping(value = "/getCounty", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getCounty(Model model, @RequestParam(value = "parentid", defaultValue = "0") Integer parentid){
        return addressService.getAddressesByParentId(parentid);
    }

    @RequestMapping(value = "/intoInsert", method = RequestMethod.GET)
    public String intoInsert(Model model){
        User user = new User();
        user.setEmail("123");
        user.setPassword("123");
        System.out.println(user);
        userService.insert(user);
        return "index";
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
            System.out.println("ok");
            userService.insertUser(user);//添加用户
            return "ok";
        }
        System.out.println("no");
        return "no";
    }
}
