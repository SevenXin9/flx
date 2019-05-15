package com.mapper;

import com.VO.ReserveVO;
import com.bean.Reserve;
import com.bean.ReserveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReserveMapper {
    int countByExample(ReserveExample example);

    int deleteByExample(ReserveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reserve record);

    int insertSelective(Reserve record);

    List<ReserveVO> selectByAll(ReserveVO reserveVO);

    List<Reserve> selectByExample(ReserveExample example);

    Reserve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByExample(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByPrimaryKeySelective(Reserve record);

    int updateByPrimaryKey(Reserve record);
}