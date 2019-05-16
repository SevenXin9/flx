package com.service.impl;

import com.VO.ReserveVO;
import com.bean.Reserve;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ReserveMapper;
import com.service.ReserveService;
import com.utils.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override// 添加订单信息
    public int  insertReservice(Integer carid, Integer userid) {
        if(reserveMapper.insertSelective(new Reserve(carid, userid, new Date())) > 0){
            return 1;
        }
        return 0;
    }
}
