package com.mapper;

import com.VO.BrandVO;
import com.bean.Brand;
import com.bean.BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    int countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(String brandIds);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByName(String  name);

    List<Brand> selectBrand(BrandVO brandVO);

    List<Brand> selectByExample(BrandExample example);

    List<Brand> selectByAll();

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}