package com.VO;

import com.bean.Car;
import com.bean.Reserve;
import com.bean.User;

/**
 * @create 2019/5/15
 */
public class ReserveVO {

    private Reserve reserve;//订单
    private Car car;//车
    private User user;//用户
    private Integer page;
    private Integer limit;

    public Reserve getReserve() {
        return reserve;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
