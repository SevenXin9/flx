package com.service.impl;

import com.VO.CarPictureTypeBrandVO;
import com.VO.CarPictureVO;
import com.bean.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.BrandMapper;
import com.mapper.CarMapper;
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
}
