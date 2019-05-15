package com.service.impl;

import com.mapper.TypeMapper;
import com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @create 2019/5/15
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override//查询所品牌
    public List<com.bean.Type> selectByAll() {
        return typeMapper.selectByAll();
    }
}
