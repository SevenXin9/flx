package com.controller;


import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class carController {

    private static Logger logger = Logger.getLogger(carController.class);

    @RequestMapping(value = "/findCar", method = RequestMethod.GET)
    public String findCar(Model model, @RequestParam(value = "brandId", defaultValue = "null")String brandId,
                          @RequestParam(value = "carPrice", defaultValue = "null")String carPrice){
        logger.info(brandId+"\t"+carPrice);
        return "cars";
    }
}
