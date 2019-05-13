package com.mapper;

import com.VO.UserVo;
import com.bean.User;
import com.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimary(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    void updatePassByEmail(User user);

    User selectByEamil(String eamil);

    List<User> selectUsers(UserVo userVo);

    int deleteByIds(@Param("ids") String ids);

}