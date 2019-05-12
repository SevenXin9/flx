package com.controller;

import com.VO.AdminVo;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminManaController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/adminMana",method = RequestMethod.GET)
    @ResponseBody
    public List<AdminVo> admin(AdminVo adminVo){
        return adminService.selectAll(adminVo);
    }
}
