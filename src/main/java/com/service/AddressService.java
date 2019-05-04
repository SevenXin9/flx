package com.service;

import com.bean.Address;
import com.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AddressService {

    /**
     * 获取所有地址信息
     * @return
     */
    public List<Address> getAddresses();

    /**
     * 查询县级地址信息
     * @param parentid
     * @return
     */
    public List<Address> getAddressesByParentId(int parentid);
}
