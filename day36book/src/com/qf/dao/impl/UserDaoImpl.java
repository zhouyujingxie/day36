package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.management.Query;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
    @Override
    public User select(String username, String password) {
        try {
            return qr.query("select * from user where username=? and password=?",new BeanHandler<>(User.class),username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
