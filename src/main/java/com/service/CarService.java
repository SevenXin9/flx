package com.service;

import com.VO.CarPictureVO;
import com.mapper.CarMapper;

import java.util.List;

/**
 * @create 2019/5/5
 */
public interface CarService {
    /**
     * 获取新车发行的车
     * @return
     */
    public List<CarPictureVO> selectCarPicture1();
}
