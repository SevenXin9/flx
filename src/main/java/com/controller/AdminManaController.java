package com.controller;

import com.bean.Admin;
import com.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.VO.AdminVo;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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

    /**
     * 删除管理员
     * @return 是否删除成功
     */
    @RequestMapping(value = "/delManage/{manageIds}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delMana(@PathVariable("manageIds") String manageIds){
        int flag= adminService.deleteByPrimaryKey(manageIds);
        if (flag ==1){
            logger.info("成功删除编号为:"+manageIds+"里的管理员");
            return true;
        }
        logger.info("管理员删除失败");
        return false;
    }


    /**
     * 跳转到修改管理员界面
     * @param id 管理员id
     * @param model 管理员信息
     * @return
     */
    @RequestMapping(value = "/toUpManage/{manageId}",method = RequestMethod.GET)
    public String toUpMana(@PathVariable("namageId") Integer id, Model model){
        model.addAttribute("manage",adminService.selectByPrimaryKey(id));
        return "";
    }


    /**
     * 修改管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/upManage",method = RequestMethod.PUT)
    @ResponseBody
    public boolean upMana(Admin admin){
            if (adminService.updateByPrimaryKeySelective(admin)==1){
                return true;
            }
            return false;
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/addManage",method = RequestMethod.POST)
    @ResponseBody
    public boolean addMana(Admin admin){
        if (adminService.insert(admin)==1){
            return true;
        }
        return false;
    }

    /**
     * 条件查询管理员信息
     * @param adminVo
     * @return
     */
    @RequestMapping(value = "/adminMana",method = RequestMethod.GET)
    @ResponseBody
    public List<AdminVo> admin(AdminVo adminVo){
        return adminService.selectAll(adminVo);
    }
}
