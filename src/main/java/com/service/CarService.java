package com.service;

import com.VO.CarPictureTypeBrandVO;
import com.VO.CarPictureVO;
import com.bean.Brand;
import com.bean.Car;
import com.bean.Type;

import java.util.List;
import java.util.Map;

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
    public List<CarPictureVO> selectCarPicture4(Integer id);

    /**
     * 获取车所有品牌信息
     * @return
     */
    public List<Brand> getBrands();

    /**
     * 条件查询汽车信息
     * @param carPictureTypeBrandVO
     * @return
     */
    public Map<String,Object> getCarPictureTypeVOs(CarPictureTypeBrandVO carPictureTypeBrandVO);

    /**
     * 条件查询汽车数量
     * @param carPictureTypeBrandVO
     * @return
     */
    public Integer getCarPictureTypeVOsCount(CarPictureTypeBrandVO carPictureTypeBrandVO);

    /**
     * 根据车ID查询汽车信息
     * @param id 汽车ID
     * @return
     */
    public CarPictureTypeBrandVO getCarPictureTypeVO(Integer id);

    /**
     * 查询所有汽车类型
     * @return
     */
    public List<Type> getTypes();

    /**
     * 根据id删除车辆信息
     * @param carIds
     * @return
     */
    public int DelCar(String carIds);

    /**
     * 添加车辆信息
     * @param carPictureVO
     * @return
     */
    public int insert(CarPictureVO carPictureVO);

    /**
     * 查询所有车信息
     * @return
     */
    public List<Car> selectByAll();
}
