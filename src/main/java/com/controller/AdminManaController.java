package com.controller;

import com.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "/manage/{manageIds}",method = RequestMethod.DELETE)
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
}
