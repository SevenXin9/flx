package com.controller;

import com.VO.BrandVO;
import com.bean.Brand;
import com.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @create 2019/5/14
 */
@RequestMapping(value = "/admin")
@Controller
public class BrandManaController {

    @Autowired
    private BrandService brandService;

    // 进入品牌管理界面
    @RequestMapping(value = "/intoBrandMana", method = RequestMethod.GET)
    public String intoBrand(){
        return "/admin/brandMana/brandMana";
    }

    //进入品牌添加界面
    @RequestMapping(value = "/toAppendBrand", method = RequestMethod.GET)
    public String toAppendBrand(){
        return "/admin/brandMana/addBrand";
    }

    //进入品牌修改界面
    @RequestMapping(value = "/toUpBrand/{id}", method = RequestMethod.GET)
    public String toUpBrand(@PathVariable("id") Integer id, Model model){
        model.addAttribute("brand",brandService.selectByPrimaryKey(id));
        return "/admin/brandMana/editBrand";
    }
    /**
     * 获取品牌的信息
     * @param brandVO
     * @return
     */
    @RequestMapping(value = "/brand",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> brandIndex(BrandVO brandVO){
        return brandService.selectBrands(brandVO);
    }

    /**
     * 添加品牌
     * @param brand
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/brand",method = RequestMethod.POST)
    public boolean appendBrand(Brand brand){
        if (brandService.appendBrand(brand)==1){
            return true;
        }return false;
    }

    /**
     * 删除品牌
     * @param brandIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/brand/{ids}",method = RequestMethod.DELETE)
    public boolean delBrand(@PathVariable("ids") String brandIds){
        if (brandService.delBrand(brandIds)==1){
            return true;
        }return false;
    }

    /**
     * 修改品牌
     * @param brand
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/brand",method = RequestMethod.PUT)
    public boolean delBrand(Brand brand){
        if (brandService.upBrand(brand)==1){
            return true;
        }return false;
    }
}
