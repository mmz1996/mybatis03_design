package com.mmz.mybatis.utils;

import com.mmz.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Classname DataSourceUtil
 * @Description TODO
 * @Date 2020/4/30 20:59
 * @Created by mmz
 */
public class DataSourceUtil {

    public static  Connection getConnection(Configuration configuration){
        try {
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(),configuration.getUsername(),configuration.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
