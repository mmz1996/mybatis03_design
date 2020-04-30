package com.mmz.mybatis.sqlsession;

import com.mmz.mybatis.cfg.Configuration;
import com.mmz.mybatis.sqlsession.proxy.MapperProxy;
import com.mmz.mybatis.utils.DataSourceUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Classname DefaultSqlSession
 * @Description TODO
 * @Date 2020/4/30 18:04
 * @Created by mmz
 */
public class DefaultSqlSession implements  SqlSession {
    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration,Connection connection){
        this.configuration = configuration;
        this.connection = DataSourceUtil.getConnection(configuration);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(configuration.getMappers(),connection));

    }

    public void close() {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
