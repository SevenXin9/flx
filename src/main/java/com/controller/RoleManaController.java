package com.controller;

import com.VO.RoleVo;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class RoleManaController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> roles(RoleVo roleVo){
        return roleService.findRoles(roleVo);
    }

}
