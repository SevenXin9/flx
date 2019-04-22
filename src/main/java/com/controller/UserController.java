package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("msg","这是首页");
        return "index";
    }
}
