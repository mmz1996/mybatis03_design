package com.mmz.mybatis.sqlsession;

/**
 * @Classname SqlSession
 * @Description 自定义mybatis与数据库交互类，创建Dao的代理对象
 * @Date 2020/4/30 17:42
 * @Created by mmz
 */
public interface SqlSession {
    //根据参数创建一个代理对象，传入的参数是dao的接口字节码
    <T> T  getMapper(Class<T> daoInterfaceClass);

    //释放资源
    void close();
}
