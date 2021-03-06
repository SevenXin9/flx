package com.controller;

import com.VO.RoleVo;
import com.service.RoleService;
import com.bean.Role;
import com.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
    @RequiresPermissions(value = "role:view")
    public String intoRoleMana(){
        return "/admin/roleMana/roleMana";
    }

    // 进入角色添加界面
    @RequestMapping(value = "intoAddRole", method = RequestMethod.GET)
    public String intoAddRole(){
        return "/admin/roleMana/addRole";
    }

    // 进入修改角色界面
    @RequestMapping(value = "intoEditRole/{roleId}", method = RequestMethod.GET)
    public String intoEditRole(@PathVariable("roleId") Integer id, Model model) {
        model.addAttribute("role",roleService.findRole(id));
        return "/admin/roleMana/editRole";
    }

    // 进入角色授权界面
    @RequestMapping(value = "intoGrantRole", method = RequestMethod.GET)

    public String intoGrantRole(){
        return "/admin/roleMana/grantRole";
    }

    /**
     * 添加角色
     * @param role 权限实例
     * @return
     */
    @RequestMapping(value = "/role",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("role:create")
    public boolean addRole(Role role){
        if (roleService.insert(role)==1){
            return true;
        }
        return false;
    }

    /**
     * 修改角色
     * @param role 权限实例
     * @return
     */
    @RequestMapping(value = "/role",method = RequestMethod.PUT)
    @ResponseBody
    @RequiresPermissions("role:update")
    public boolean upRole(Role role){
        if (roleService.updataRole(role)==1){
            return true;
        }return false;
    }

    /**
     * 删除角色
     * @param roleIds 权限的id
     * @return
     */
    @RequestMapping(value = "/role",method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresPermissions("role:delete")
    public boolean delRole(String roleIds){
        System.out.println(roleIds);
        if (roleService.delRole(roleIds)==1){
            return true;
        }
        return false;
    }

    /**
     * 条件查询角色
     * @param roleVo
     * @return
     */
    @RequestMapping(value = "/role",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = "role:view")
    public Map<String,Object> roles(RoleVo roleVo){
        return roleService.findRoles(roleVo);
    }


    /**
     * 修改用户权限
     * @param roleId
     * @param authorityId
     * @param falg
     */
    @RequestMapping(value = "/authority",method = RequestMethod.PUT)
    @ResponseBody
    public void changeRoleAuthority(Integer roleId,String authorityId,boolean falg){
        if(falg){
            roleService.addAuthority(roleId,authorityId);
        }else {
            roleService.delAuthority(roleId,authorityId);
        }
    }
}
