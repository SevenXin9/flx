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

    int deleteByPrimaryKey(Integer id);

    int insert(Car record);

    int insertSelective(Car record);

    List<CarPictureVO> selectCarPicture1();//查询即将发行车信息
    List<CarPictureVO> selectCarPicture2();//查询流行车
    List<CarPictureVO> selectCarPicture3();//查询新车上市
    List<CarPictureVO> selectCarPicture4(Integer id);//查询轮播图展示车

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<CarPictureTypeBrandVO> selectByCar(CarPictureTypeBrandVO carPictureTypeBrandVO);// 根据条件查询车的所有信息;

    CarPictureTypeBrandVO selectVoByKey(@Param("id") Integer id);
}