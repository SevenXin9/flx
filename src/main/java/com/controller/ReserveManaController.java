package com.controller;

import com.VO.ReserveVO;
import com.mapper.ReserveMapper;
import com.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @create 2019/5/15
 */
@RequestMapping(value = "/admin")
@Controller
public class ReserveManaController {

    @Autowired
    private ReserveService reserveService;


    /**
     * 条件查询订单信息
     * @param reserveVO
     * @return
     */
    @RequestMapping(value = "/reserve",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> reserve(ReserveVO reserveVO){
        return reserveService.selectByAll(reserveVO);
    }

    /**
     * 进入reserve页面
     * @return
     */
    @RequestMapping(value = "/intoReserve",method = RequestMethod.GET)
    public String intoReserve(){
        return "/admin/reserveMana/reserveMana";
    }
}
