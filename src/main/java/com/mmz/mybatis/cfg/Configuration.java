package com.mmz.mybatis.cfg;

import com.mmz.mybatis.utils.Mapper;
import lombok.Data;

import java.util.Map;

/**
 * @Classname Configuration
 * @Description 自定义mybatis配置类
 * @Date 2020/4/30 17:50
 * @Created by mmz
 */
@Data
public class Configuration {

    private String driver;
    private String url;
    private String password;
    private String username;
    private Map<String, Mapper> mappers;

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);//此处需要追加的方式
    }
}
