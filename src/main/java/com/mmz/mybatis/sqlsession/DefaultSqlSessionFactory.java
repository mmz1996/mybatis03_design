package com.mmz.mybatis.sqlsession;

import com.mmz.mybatis.cfg.Configuration;

/**
 * @Classname DefaultSqlSessionFactory
 * @Description SqlSessionFactory实现类
 * @Date 2020/4/30 18:01
 * @Created by mmz
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration){
        this.configuration = configuration;
    }
}
