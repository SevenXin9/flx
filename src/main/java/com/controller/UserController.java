package com.controller;

import com.bean.Address;
import com.bean.User;
import com.service.AddressService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
