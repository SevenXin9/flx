package com.service.impl;

import com.VO.CarPictureTypeBrandVO;
import com.VO.CarPictureVO;
import com.bean.Brand;
import com.bean.Picture;
import com.mapper.BrandMapper;
import com.mapper.CarMapper;
import com.mapper.PictureMapper;
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
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private PictureMapper pictureMapper;

    // 即将发行
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
    //条件查询汽车数量
    @Override
    public Integer getCarPictureTypeVOsCount(CarPictureTypeBrandVO carPictureTypeBrandVO){
        return carMapper.selectByCarCount(carPictureTypeBrandVO);
    }
    // 根据车ID查询汽车信息
    @Override
    public CarPictureTypeBrandVO getCarPictureTypeVO(Integer id) {
        return carMapper.selectVoByKey(id);
    }

    @Override//根据id删除车信息
    public int DelCar(String carIds) {
        return carMapper.deleteByPrimaryKey(carIds);
    }

    @Override//添加车信息
    public int insert(CarPictureVO carPictureVO) {
        int id=carMapper.insertSelective(carPictureVO);//添加车的信息  id为次车辆的主键
        Picture picture =new Picture();
        picture.setUrl(carPictureVO.getUrl());
        picture.setCarId(id);
        return pictureMapper.insertSelective(picture);  //添加车的图片地址
    }
}
