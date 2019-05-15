package com.controller;

import com.bean.Role;
import com.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @create 2019/5/13
 */
@RequestMapping(value = "/admin")
@Controller
public class RoleManaController {

    @Autowired
    private RoleService roleService;

    // 进入角色管理界面
    @RequestMapping(value = "intoRoleMana", method = RequestMethod.GET)
    public String intoRoleMana(){
        return "/admin/roleMana/roleMana";
    }

    // 进入角色添加界面
    @RequestMapping(value = "intoAddRole", method = RequestMethod.GET)
    public String intoAddRole(){
        return "/admin/roleMana/addRole";
    }

    // 进入修改角色界面
    @RequestMapping(value = "intoEditRole", method = RequestMethod.GET)
    public String intoEditRole(){
        return "/admin/roleMana/editRole";
    }

    // 进入角色授权界面
    @RequestMapping(value = "intoGrantRole", method = RequestMethod.GET)
    public String intoGrantRole(){
        return "/admin/roleMana/grantRole";
    }

    /**
     * 添加权限
     * @param role 权限实例
     * @return
     */
    @RequestMapping(value = "role",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("role:append")
    public boolean addRole(Role role){
        if (roleService.insert(role)==1){
            return true;
        }return false;
    }

    /**
     * 修改权限
     * @param role 权限实例
     * @return
     */
    @RequestMapping(value = "role",method = RequestMethod.PUT)
    @ResponseBody
    @RequiresPermissions("role:update")
    public boolean upRole(Role role){
        if (roleService.updataRole(role)==1){
            return true;
        }return false;
    }

    /**
     * 删除权限
     * @param roleIds 权限的id
     * @return
     */
    @RequestMapping(value = "role",method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresPermissions("role:delete")
    public boolean delRole(String roleIds){
        if (roleService.delRole(roleIds)==1){
            return true;
        }return false;
    }
}
