package com.service;

import com.bean.Type;

import java.util.List;

/**
 * @create 2019/5/15
 */
public interface TypeService {

    /**
     * 查询所有汽车类型
     * @return
     */
    public List<Type> selectByAll();
}
