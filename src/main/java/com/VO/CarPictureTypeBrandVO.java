package com.VO;

import com.bean.Brand;
import com.bean.Car;
import com.bean.Picture;
import com.bean.Type;
import com.controller.IndexController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;

public class CarPictureTypeBrandVO {

    private Integer id;

    private Car car;

    private Picture picture;

    private Type type;

    private Brand brand;

    private Double pricemax;

    private Double pricemin;

    private Integer limit;

    private Integer page;

    private Integer start;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Double getPricemax() {
        return pricemax;
    }

    public void setPricemax(Double pricemax) {
        this.pricemax = pricemax;
    }

    public Double getPricemin() {
        return pricemin;
    }

    public void setPricemin(Double pricemin) {
        this.pricemin = pricemin;
    }
}
