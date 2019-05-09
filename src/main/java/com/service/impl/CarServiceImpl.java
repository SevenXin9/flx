package com.service.impl;

import com.VO.CarPictureTypeBrandVO;
import com.VO.CarPictureVO;
import com.bean.Brand;
import com.bean.Type;
import com.mapper.BrandMapper;
import com.mapper.CarMapper;
import com.mapper.TypeMapper;
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
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private TypeMapper typeMapper;

    // 即将发行
    @Override
    public List<CarPictureVO> selectCarPicture1() {
        return carMapper.selectCarPicture1();
    }

    // 流行车
    @Override
    public List<CarPictureVO> selectCarPicture2() {
        return carMapper.selectCarPicture2();
    }

    // 新车上市
    @Override
    public List<CarPictureVO> selectCarPicture3() {
        return carMapper.selectCarPicture3();
    }

    // 轮播图展示车
    @Override
    public List<CarPictureVO> selectCarPicture4() {
        return carMapper.selectCarPicture4();
    }

    // 获取车所有品牌信息
    @Override
    public List<Brand> getBrands() {
        return brandMapper.selectByExample(null);
    }

    // 条件查询汽车信息
    @Override
    public List<CarPictureTypeBrandVO> getCarPictureTypeVOs(CarPictureTypeBrandVO carPictureTypeBrandVO) {
        return carMapper.selectByCar(carPictureTypeBrandVO);
    }

    // 根据车ID查询汽车信息
    @Override
    public CarPictureTypeBrandVO getCarPictureTypeVO(Integer id) {
        return carMapper.selectVoByKey(id);
    }

    // 查询所有汽车类型
    @Override
    public List<Type> getTypes() {
        return typeMapper.selectByExample(null);
    }
}
