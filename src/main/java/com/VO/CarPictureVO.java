package com.VO;

import com.bean.Car;

/**
 * @create 2019/5/5
 */
public class CarPictureVO {
    private Car car;
    private String url;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
