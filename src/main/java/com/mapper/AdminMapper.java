package com.mapper;

import com.VO.AdminVo;
import com.bean.Admin;
import com.bean.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String manageIds);

    int insert(Admin record);

    Admin selectByNamePass(String name);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 条件查询管理员
     * @param adminVo
     * @return
     */
    List<AdminVo> selectAdmin(AdminVo adminVo);
}