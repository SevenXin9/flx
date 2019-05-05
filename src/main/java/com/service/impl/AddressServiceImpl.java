package com.service.impl;

import com.bean.Address;
import com.mapper.AddressMapper;
import com.service.AddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    // 获取所有地址信息
    @Override
    public List<Address> getAddresses() {
        return addressMapper.selectByExample(null);
    }

    // 查询县级地址信息
    @Override
    public List<Address> getAddressesByParentId(int parentid) {
        return addressMapper.selectByParentId(parentid);
    }
}
