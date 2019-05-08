package com.service;

import com.bean.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询全部品牌的信息
     * @return 全部品牌的集合
     */
    public List<Brand> selectBrands();
}
