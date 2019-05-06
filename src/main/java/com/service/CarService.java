package com.service;

import com.VO.CarPictureVO;
import com.bean.Brand;
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

    /**
     * 查询流行车
     * @return
     */
    public List<CarPictureVO> selectCarPicture2();

    /**
     * 查询新车上市
     * @return
     */
    public List<CarPictureVO> selectCarPicture3();

    /**
     * 轮播图展示车
     * @return
     */
    public List<CarPictureVO> selectCarPicture4();

    /**
     * 获取车所有品牌信息
     * @return
     */
    public List<Brand> getBrands();
}
