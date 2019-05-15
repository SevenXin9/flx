package com.controller;

import com.VO.AuthorityVo;
import com.bean.Authority;
import com.mapper.AuthorityMapper;
import com.service.AuthorityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AuthorityController{
    @Autowired
    private AuthorityService authorityService;

    @RequestMapping(value = "/authority",method = RequestMethod.GET)
    @RequiresPermissions("rolegrant")
    public String authority(String roleId,String ids, Model model){
        List<Authority> authorityList = authorityService.showAuthoritys();
        List<AuthorityVo> authorityVos = new ArrayList<AuthorityVo>();
        if (ids==null||ids.equals("")){
            for (Authority authority:authorityList) {
                authorityVos.add(new AuthorityVo(authority,false));
            }
        }else {
            List<Authority> authorities = authorityService.findAuthoritys(ids);
            boolean falg = false;
            for (Authority authority : authorityList) {
                falg = false;
                for (Authority authority1 : authorities) {
                    if (authority.getId().equals(authority1.getId())) {
                        System.out.println(authority.getId() + ":" + authority1.getId());
                        falg = true;
                    }
                }
                authorityVos.add(new AuthorityVo(authority, falg));
            }
        }
        model.addAttribute("authorities",authorityVos);
        model.addAttribute("roleId",roleId);
        return "admin/roleMana/grantRole";
    }

}
