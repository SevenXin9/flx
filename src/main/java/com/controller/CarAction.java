package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @create 2019/4/22
 */
@Controller
public class CarAction {

    @RequestMapping(value = "/demo")
    public void demo(){
        System.out.println("进来了");
    }
}
