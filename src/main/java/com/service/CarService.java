package com.service;

import com.VO.CarPictureTypeBrandVO;
import com.VO.CarPictureVO;
import com.bean.Brand;

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

    /**
     * 条件查询汽车信息
     * @param carPictureTypeBrandVO
     * @return
     */
    public List<CarPictureTypeBrandVO> getCarPictureTypeVOs(CarPictureTypeBrandVO carPictureTypeBrandVO);

    /**
     * 条件查询汽车数量
     * @param id
     * @return
     */
    public Integer getCarPictureTypeVOsCount(CarPictureTypeBrandVO carPictureTypeBrandVO);

    /**
     * 根据车ID查询汽车信息
     * @param id 汽车ID
     * @return
     */
    public CarPictureTypeBrandVO getCarPictureTypeVO(Integer id);
}
