package com.VO;

import com.bean.Brand;
import com.bean.Car;
import com.bean.Picture;
import com.bean.Type;

public class CarPictureTypeBrandVO {

    private Integer id;

    private Car car;

    private Picture picture;

    private Type type;

    private Brand brand;

    private Double pricemax;

    private Double pricemin;

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
