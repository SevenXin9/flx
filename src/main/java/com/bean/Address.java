package com.bean;

public class Address {
    private Integer id;

    private String addressname;

    private Integer parentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname == null ? null : addressname.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressname='" + addressname + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}