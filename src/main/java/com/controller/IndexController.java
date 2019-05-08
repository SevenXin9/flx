package com.controller;

import com.VO.CarPictureVO;
import com.bean.Address;
import com.bean.Brand;
import com.service.AddressService;
import com.service.BrandService;
import com.service.CarService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private BrandService brandService;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        logger.debug("s");
        // 获取省级城市信息
        List<Address> addresses = addressService.getAddressesByParentId(-1);
        // 获取新车发行的车
        List<CarPictureVO> Cars1=carService.selectCarPicture1();
        //流行车
        List<CarPictureVO> Cars2=carService.selectCarPicture2();
        //新车上市
        List<CarPictureVO> Cars3=carService.selectCarPicture3();
        //轮播图展示车
        List<CarPictureVO> Cars4=carService.selectCarPicture4();
        //获得所有品牌信息
        List<Brand> brands = brandService.selectBrands();
        model.addAttribute("addresses", addresses);
        model.addAttribute("Cars",Cars1);
        model.addAttribute("Cars2",Cars2);
        model.addAttribute("Cars3",Cars3);
        model.addAttribute("Cars4",Cars4);
        model.addAttribute("brands",brands);
        return "index";
    }
}
