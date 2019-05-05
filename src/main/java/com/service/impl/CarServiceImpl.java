package com.service.impl;

import com.VO.CarPictureVO;
import com.mapper.CarMapper;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2019/5/5
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<CarPictureVO> selectCarPicture1() {
        return carMapper.selectCarPicture1();
    }
}
