package com.service.impl;

import com.VO.BrandVO;
import com.bean.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.BrandMapper;
import com.service.BrandService;
import com.utils.LayuiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    //查询所有品牌的信息
    @Override
    public Map<String,Object> selectBrands(BrandVO brandVO) {
        PageInfo<Brand> pageInfo = PageHelper.startPage(brandVO.getPage(),brandVO.getLimit()).doSelectPageInfo(()->brandMapper.selectBrand(brandVO));
        return LayuiUtil.data(pageInfo.getTotal(),pageInfo.getList());
    }

    @Override//查询所有品牌信息
    public List<Brand> selectByAll() {
        return brandMapper.selectByAll();
    }

    @Override//修改品牌信息
    public int upBrand(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override//删除品牌信息
    public int delBrand(String brandIds) {
        return brandMapper.deleteByPrimaryKey(brandIds);
    }

    @Override//添加商品
    public int appendBrand(Brand brand) {
        if (brandMapper.selectByName(brand.getName())!=null){
            return 0;
        }
        return brandMapper.insert(brand);
    }

    @Override//根据主键查询品牌
    public Brand selectByPrimaryKey(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
