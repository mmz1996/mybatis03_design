package com.mmz.mybatis.sqlsession;

import com.mmz.mybatis.cfg.Configuration;

/**
 * @Classname DefaultSqlSession
 * @Description TODO
 * @Date 2020/4/30 18:04
 * @Created by mmz
 */
public class DefaultSqlSession implements  SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration){
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return null;
    }

    public void close() {

    }
}
