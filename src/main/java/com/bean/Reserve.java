package com.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Reserve {
    private Integer id;

    private Integer carid;

    private Integer userid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd",timezone = "GMT+8")
    private Date time;

    public Reserve() {
    }

    public Reserve(Integer carid, Integer userid, Date time) {
        this.carid = carid;
        this.userid = userid;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", carid=" + carid +
                ", userid=" + userid +
                ", time=" + time +
                '}';
    }
}