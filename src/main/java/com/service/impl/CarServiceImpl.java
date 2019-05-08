package com.service.impl;

import com.VO.CarPictureVO;
import com.mapper.CarMapper;
import com.service.CarService;
import com.utils.DateUtil;
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
    /**
     * 即将发行
     */
    public List<CarPictureVO> selectCarPicture1(){
        return carMapper.selectCarPicture1();
    }

    /**
     * 流行车
     * @return
     */
    @Override
    public List<CarPictureVO> selectCarPicture2() {
        return carMapper.selectCarPicture2();
    }

    /**
     * 新车上市
     * @return
     */
    @Override
    public List<CarPictureVO> selectCarPicture3() {
        return carMapper.selectCarPicture3();
    }

    /**
     * 轮播图展示车
     * @return
     */
    @Override
    public List<CarPictureVO> selectCarPicture4(Integer id) {
        return carMapper.selectCarPicture4(id);
    }

}
