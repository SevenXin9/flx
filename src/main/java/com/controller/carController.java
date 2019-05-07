package com.controller;


import com.VO.CarPictureTypeBrandVO;
import com.service.CarService;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/user")
public class carController {

    private static Logger logger = Logger.getLogger(carController.class);

    @Autowired
    private CarService carService;

    // 条件查询车信息
    @RequestMapping(value = "/findCar", method = RequestMethod.GET)
    public String findCar(Model model, CarPictureTypeBrandVO carPictureTypeBrandVO){
        List<CarPictureTypeBrandVO> carPictureTypeBrandVOS = carService.getCarPictureTypeVOs(carPictureTypeBrandVO);
        model.addAttribute("carPictureTypeVOs", carPictureTypeBrandVOS);
        return "cars";
    }
}
