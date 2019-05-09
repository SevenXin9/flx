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
    @ResponseBody
    public List<CarPictureTypeBrandVO> findCar(CarPictureTypeBrandVO carPictureTypeBrandVO){
        if (carPictureTypeBrandVO.getPage()==null||carPictureTypeBrandVO.getPage()<=0){
            carPictureTypeBrandVO.setPage(1);
        }
        carPictureTypeBrandVO.setLimit(6);
        carPictureTypeBrandVO.setStart((carPictureTypeBrandVO.getPage()-1)*carPictureTypeBrandVO.getLimit());
        List<CarPictureTypeBrandVO> carPictureTypeBrandVOS = carService.getCarPictureTypeVOs(carPictureTypeBrandVO);
        //model.addAttribute("carPictureTypeVOs", carPictureTypeBrandVOS);
        return carPictureTypeBrandVOS;
    }

    @RequestMapping(value = "/findCarCount", method = RequestMethod.GET)
    @ResponseBody
    public Integer findCarCount(CarPictureTypeBrandVO carPictureTypeBrandVO){
        Integer count = carService.getCarPictureTypeVOsCount(carPictureTypeBrandVO);
        return (count + 6 - 1) /6;
    }
    @RequestMapping(value = "/toCars", method = RequestMethod.GET)
    public String toCars(){
        return "cars";
    }

    // 根据车ID查询车信息
    @RequestMapping(value = "/findCarId", method = RequestMethod.GET)
    @ResponseBody
    public CarPictureTypeBrandVO findCarId(@RequestParam(value = "id", defaultValue = "-1")Integer id){
        return carService.getCarPictureTypeVO(id);
    }
}