package com.mmz.mybatis.sqlsession;

/**
 * @Classname SqlSessionFactory
 * @Description TODO
 * @Date 2020/4/30 17:40
 * @Created by mmz
 */
public interface SqlSessionFactory {
    //用于打开SqlSession对象
    SqlSession openSession();
}
