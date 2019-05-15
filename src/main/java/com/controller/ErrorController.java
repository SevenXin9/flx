package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ErrorController {
    @RequestMapping("/error/403")
    public String error(){
        return "/error/403";
    }
}
