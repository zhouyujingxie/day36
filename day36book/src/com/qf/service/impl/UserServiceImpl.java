package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.entity.User;
import com.qf.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        User user=userDao.select(username,password);
        if(user==null){
            throw new RuntimeException("用户名或密码错误");
        }
        return user;
    }
}
