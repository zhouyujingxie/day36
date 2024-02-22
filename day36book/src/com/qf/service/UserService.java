package com.qf.service;

import com.qf.entity.User;

public interface UserService {
    User login(String username,String password);
}
