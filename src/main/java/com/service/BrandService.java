package com.service;

import com.VO.BrandVO;
import com.bean.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    /**
     * 查询全部品牌的信息
     * @return 全部品牌的集合
     */
    public Map<String,Object> selectBrands(BrandVO brandVO);

    /**
     * 查询所有品牌信息
     * @return
     */
    public List<Brand> selectByAll();

    /**
     * 修改品牌信息
     * @param brand
     * @return
     */
    public int upBrand(Brand brand);

    /**
     * 删除品牌
     * @param brandIds
     * @return
     */
    public int delBrand(String brandIds);

    /**
     * 添加品牌
     * @param brand
     * @return
     */
    public int appendBrand(Brand brand);

    /**
     * 根据主键查询品牌信息
     * @param id
     * @return
     */
    public Brand selectByPrimaryKey(Integer id);
}
