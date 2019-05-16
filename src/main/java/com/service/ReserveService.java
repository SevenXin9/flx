package com.service;

import com.VO.ReserveVO;

import java.util.List;
import java.util.Map;

/**
 * @create 2019/5/15
 */
public interface ReserveService {

    /**
     * 查询所有订单，可添加条件
     * @param reserveVO
     * @return
     */
    public Map<String, Object> selectByAll(ReserveVO reserveVO);

    /**
     * 添加订单信息
     * @param carid 车id
     * @return
     */
    public int  insertReservice(Integer carid, Integer userid);
}
