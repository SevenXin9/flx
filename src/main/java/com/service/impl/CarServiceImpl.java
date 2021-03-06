package com.service.impl;

import com.VO.CarPictureTypeBrandVO;
import com.VO.CarPictureVO;
import com.bean.Brand;
import com.bean.Car;
import com.bean.Type;
import com.bean.Picture;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.BrandMapper;
import com.mapper.CarMapper;
import com.mapper.TypeMapper;
import com.mapper.PictureMapper;
import com.service.CarService;
import com.utils.DateUtil;
import com.utils.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public Map<String,Object> getCarPictureTypeVOs(CarPictureTypeBrandVO carPictureTypeBrandVO) {
        PageInfo<CarPictureTypeBrandVO> pageInfo = PageHelper.startPage(carPictureTypeBrandVO.getPage(), carPictureTypeBrandVO.getLimit()).doSelectPageInfo(() -> carMapper.selectByCar(carPictureTypeBrandVO));
        return LayuiUtil.data(pageInfo.getTotal(),pageInfo.getList());
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

    // 查询所有汽车类型
    @Override
    public List<Type> getTypes() {
        return typeMapper.selectByExample(null);
    }

    @Override//根据id删除车信息
    public int DelCar(String carIds) {
        return carMapper.deleteByPrimaryKey(carIds);
    }

    @Override//添加车信息
    public int insert(CarPictureVO carPictureVO) {
        carMapper.insert(carPictureVO);//添加车的信息  id为次车辆的主键
        Picture picture =new Picture();
        picture.setUrl(carPictureVO.getUrl());
        picture.setCarId(carPictureVO.getId());
        return pictureMapper.insertSelective(picture);  //添加车的图片地址
    }

    @Override//查询所有车
    public List<Car> selectByAll() {
        return carMapper.selectByAll();
    }
}
