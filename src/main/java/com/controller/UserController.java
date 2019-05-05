package com.controller;

import com.VO.CarPictureVO;
import com.bean.User;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import com.bean.Address;
import com.bean.Address;
import com.service.AddressService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

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
        List<CarPictureVO> Cars1=carService.selectCarPicture1();
        //流行车
        List<CarPictureVO> Cars2=carService.selectCarPicture2();
        //新车上市
        List<CarPictureVO> Cars3=carService.selectCarPicture3();
        //轮播图展示车
        List<CarPictureVO> Cars4=carService.selectCarPicture4();
        System.out.println(Cars1.size()+"            "+Cars2.get(2).getUrl()+"                 "+Cars2.size());
        model.addAttribute("addresses", addresses);
        model.addAttribute("Cars",Cars1);
        model.addAttribute("Cars2",Cars2);
        model.addAttribute("Cars3",Cars3);
        model.addAttribute("Cars4",Cars4);
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
    /**
     * 注册
     */
    public String regest(User user,@RequestParam("name") String verify2,HttpSession session){
        System.out.println(user.getEmail()+"          "+user.getPassword());
        if (session.getAttribute("verify").equals(verify2)){//比较验证码
            session.removeAttribute("verify");
            userService.insertUser(user);//添加用户
            return "ok";
        }
        return "no";
    }

}
