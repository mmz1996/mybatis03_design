package com.mmz.mybatis.io;

import java.io.InputStream;

/**
 * @Classname Resources
 * @Description 使用类加载器读取配置文件类
 * @Date 2020/4/30 17:37
 * @Created by mmz
 */
public class Resources {
    //根据传入的参数，获取一个字节流
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }

}
