package com.controller;

import com.bean.Admin;
import com.service.AdminService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.VO.AdminVo;
import com.bean.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AdminService;
import com.utils.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @create 2019/5/12
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminManaController {

    @Autowired
    private AdminService adminService;
    //日志
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    // 进入管理员管理界面
    @RequestMapping(value = "intoAdminMana", method = RequestMethod.GET)
    public String intoAdmin(){
        return "/admin/adminMana/adminMana";
    }

    // 进入添加管理员界面
    @RequestMapping(value = "intoAddAdmin", method = RequestMethod.GET)
    public String intoAddAdmin(){
        return "/admin/adminMana/addAdmin";
    }

    /**
     * 删除管理员
     * @return 是否删除成功
     */
    @RequestMapping(value = "/Manage/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delManage(@PathVariable("ids") String manageIds){
        return adminService.deleteByPrimaryKey(manageIds);
    }


    /**
     * 跳转到修改管理员界面
     * @param id 管理员id
     * @param model 管理员信息
     * @return
     */
    @RequestMapping(value = "/toUpManage/{manageId}",method = RequestMethod.GET)
    public String toUpMana(@PathVariable("manageId") Integer id, Model model){
        model.addAttribute("manage",adminService.selectByPrimaryKey(id));
        return "/admin/adminMana/editAdmin";
    }


    /**
     * 修改管理员
     * @param admin
     * @return 0:修改失败 1:修改成功 2:用户名已存在
     */
    @RequestMapping(value = "/Manage",method = RequestMethod.PUT)
    @ResponseBody
    public int upManage(Admin admin){
        System.out.println(admin.getName());
        System.out.println(admin.getPassword());
        System.out.println(admin.getId());
        System.out.println(admin.getRole());
        return adminService.updateByPrimaryKeySelective(admin);
    }

    /**
     * 添加管理员
     * @param admin
     * @return 0:添加失败 1:添加成功 2:用户名已存在
     */
    @RequestMapping(value = "/Manage",method = RequestMethod.POST)
    @ResponseBody
    public int addMana(Admin admin){
        return adminService.insert(admin);
    }

    /**
     * 条件查询管理员信息
     * @param adminVo
     * @return
     */
    @RequestMapping(value = "/Manage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> admin(AdminVo adminVo){
        return adminService.selectAll(adminVo);
    }
}
