package com.mmz.mybatis.sqlsession;

import com.mmz.mybatis.cfg.Configuration;
import com.mmz.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @Classname SqlSessionFactoryBuilder
 * @Description 用于创建一个SqlSessionFactory对象
 * @Date 2020/4/30 17:39
 * @Created by mmz
 */
public class SqlSessionFactoryBuilder {
    //根据参数的输入流，构建一个SqlSessionFactory
    public SqlSessionFactory build(InputStream inputStream){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
