package com.service.impl;

import com.bean.Brand;
import com.mapper.BrandMapper;
import com.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    //查询所有品牌的信息
    @Override
    public List<Brand> selectBrands() {
        List<Brand> brands = brandMapper.selectByExample(null);
        return brands;
    }
}
