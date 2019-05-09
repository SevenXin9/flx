package com.controller;


import com.VO.CarPictureTypeBrandVO;
import com.bean.Brand;
import com.bean.Type;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public class CarController {


    @Autowired
    private CarService carService;

    // 条件查询车信息进入cars界面
    @RequestMapping(value = "/findCar", method = RequestMethod.GET)
    public String findCar(Model model, CarPictureTypeBrandVO carPictureTypeBrandVO){
        List<CarPictureTypeBrandVO> carPictureTypeBrandVOS = carService.getCarPictureTypeVOs(carPictureTypeBrandVO);
        List<Brand> brands = carService.getBrands();
        List<Type> types = carService.getTypes();
        model.addAttribute("carPictureTypeVOs", carPictureTypeBrandVOS);
        model.addAttribute("brands", brands);
        model.addAttribute("types", types);
        model.addAttribute("carPictureTypeBrandVO", carPictureTypeBrandVO);
        return "cars";
    }

    // 根据车ID查询车信息
    @RequestMapping(value = "/findCarId", method = RequestMethod.GET)
    @ResponseBody
    public CarPictureTypeBrandVO findCarId(@RequestParam(value = "id", defaultValue = "-1")Integer id){
        return carService.getCarPictureTypeVO(id);
    }

    // 根据条件查询车信息
    @RequestMapping(value = "findCars", method = RequestMethod.GET)
    @ResponseBody
    public List<CarPictureTypeBrandVO> findCars(CarPictureTypeBrandVO carPictureTypeBrandVO){
        return carService.getCarPictureTypeVOs(carPictureTypeBrandVO);
    }
}