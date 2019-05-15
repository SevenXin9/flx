package com.service.impl;

import com.VO.ReserveVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ReserveMapper;
import com.service.ReserveService;
import com.utils.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @create 2019/5/15
 */
@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveMapper reserveMapper;

    @Override//查询所有车的信息
    public Map<String, Object> selectByAll(ReserveVO reserveVO){
        PageInfo<ReserveVO> pageInfo = PageHelper.startPage(reserveVO.getPage(),reserveVO.getLimit()).doSelectPageInfo(()->reserveMapper.selectByAll(reserveVO));
        return LayuiUtil.data(pageInfo.getTotal(),pageInfo.getList());
    }
}
