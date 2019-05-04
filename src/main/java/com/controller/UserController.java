package com.controller;

import com.bean.Address;
import com.service.AddressService;
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

}
