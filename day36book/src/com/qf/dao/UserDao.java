package com.qf.dao;

import com.qf.entity.User;

public interface UserDao {
    User select(String username,String password);
}
