package com.mmz.mybatis.sqlsession.proxy;

import com.mmz.mybatis.utils.Executor;
import com.mmz.mybatis.cfg.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @Classname MapperProxy
 * @Description TODO
 * @Date 2020/4/30 18:15
 * @Created by mmz
 */
public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;

    private Connection connection;

    public MapperProxy(Map<String,Mapper> mappers,Connection connection){
        this.mappers = mappers;
        this.connection = connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在的类的名称
        String className = method.getDeclaringClass().getName();
        //组合key
        String key = className+"."+methodName;
        //获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        //判断mapper是否为空
        if(mapper == null){
            throw new IllegalArgumentException("传入参数有误");
        }
        //调用工具类查询所有

        return new Executor().selectList(mapper,connection);
    }
}
