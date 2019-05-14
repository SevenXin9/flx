package com.VO;

import com.bean.Brand;

/**
 * 封颖鹏
 * @create 2019/5/14
 */
public class BrandVO {
    private Brand brand;//品牌
    private Integer page;//当前页
    private Integer limit;//每页最大显示数量

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
