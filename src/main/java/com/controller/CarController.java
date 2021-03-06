package com.controller;


import com.VO.CarPictureTypeBrandVO;
import com.bean.Brand;
import com.bean.Type;
import com.bean.User;
import com.service.CarService;
import com.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class CarController {


    @Autowired
    private CarService carService;
    @Autowired
    private ReserveService reserveService;

    // 条件查询车信息
    @RequestMapping(value = "/findCar", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findCar(CarPictureTypeBrandVO carPictureTypeBrandVO){
        return carService.getCarPictureTypeVOs(carPictureTypeBrandVO);
    }

    // 查询总页数
    @RequestMapping(value = "/findCarCount", method = RequestMethod.GET)
    @ResponseBody
    public Integer findCarCount(CarPictureTypeBrandVO carPictureTypeBrandVO){
        Integer count = carService.getCarPictureTypeVOsCount(carPictureTypeBrandVO);
        return (count + 6 - 1) /6;
    }

    // 进入cars页面
    @RequestMapping(value = "/toCars", method = RequestMethod.GET)
    public String toCars(Model model, CarPictureTypeBrandVO carPictureTypeBrandVO){
        model.addAttribute("carPictureTypeBrandVO", carPictureTypeBrandVO);
        model.addAttribute("brands", carService.getBrands());
        model.addAttribute("types", carService.getTypes());
        return "cars";
    }

    // 根据车ID查询车信息
    @RequestMapping(value = "/findCarId", method = RequestMethod.GET)
    @ResponseBody
    public CarPictureTypeBrandVO findCarId(@RequestParam(value = "id", defaultValue = "-1")Integer id){
        return carService.getCarPictureTypeVO(id);
    }

    // 添加订单信息
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    @ResponseBody
    public int insert(@RequestParam("carid") Integer carid, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user==null)
            return 2;
        return reserveService.insertReservice(carid, user.getId());
    }
}