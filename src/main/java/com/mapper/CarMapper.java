package com.mapper;

import com.VO.CarPictureTypeBrandVO;
import com.VO.CarPictureVO;
import com.bean.Car;
import com.bean.CarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    int countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(String carIds);

    int insert(CarPictureVO record);

    int insertSelective(CarPictureVO record);//添加车辆信息并返回主键

    List<CarPictureVO> selectCarPicture1();//查询即将发行车信息
    List<CarPictureVO> selectCarPicture2();//查询流行车
    List<CarPictureVO> selectCarPicture3();//查询新车上市
    List<CarPictureVO> selectCarPicture4(Integer id);//查询轮播图展示车

    List<CarPictureTypeBrandVO> selectByCar(CarPictureTypeBrandVO carPictureTypeBrandVO);// 根据条件查询车的所有信息;

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    CarPictureTypeBrandVO selectVoByKey(@Param("id") Integer id);

    Integer selectByCarCount(CarPictureTypeBrandVO carPictureTypeBrandVO);
}