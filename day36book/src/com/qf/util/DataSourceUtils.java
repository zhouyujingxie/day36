package com.qf.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceUtils {
    private static DruidDataSource dataSource=new DruidDataSource();
    static {
        try {
            //使用类加载器加载配置文件
            //1.获取类加载器
            ClassLoader classLoader = DataSourceUtils.class.getClassLoader();
            //2.加载配置文件
            InputStream is = classLoader.getResourceAsStream("druid.properties");
            // FileInputStream fis = new FileInputStream("src\\druid.properties");
            //3.创建集合
            Properties properties = new Properties();
            properties.load(is);
            is.close();
            dataSource.configFromPropety(properties);
        } catch (IOException e) {
            System.out.println("初始化数据失败");
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
