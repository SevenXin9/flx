package com.service;

import com.bean.User;

public interface UserService {

    public void insert(User user);
    User loginVerify(User user);
}
