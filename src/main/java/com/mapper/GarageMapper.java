package com.mapper;

import com.bean.Garage;
import com.bean.GarageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarageMapper {
    int countByExample(GarageExample example);

    int deleteByExample(GarageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Garage record);

    int insertSelective(Garage record);

    List<Garage> selectByExample(GarageExample example);

    Garage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Garage record, @Param("example") GarageExample example);

    int updateByExample(@Param("record") Garage record, @Param("example") GarageExample example);

    int updateByPrimaryKeySelective(Garage record);

    int updateByPrimaryKey(Garage record);
}