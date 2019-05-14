package com.controller;

import com.VO.AdminVo;
import com.bean.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AdminService;
import com.utils.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminManaController {

    @Autowired
    private AdminService adminService;

    /**
     * 条件查询管理员信息
     * @param adminVo
     * @return
     */
    @RequestMapping(value = "/adminMana",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> admin(AdminVo adminVo){
        return adminService.selectAll(adminVo);
    }

    
}
