package com.mmz.mybatis.cfg;

import lombok.Data;

/**
 * @Classname Mapper
 * @Description 封装sql语句和结果类型的全限定类名
 * @Date 2020/4/30 17:52
 * @Created by mmz
 */
@Data
public class Mapper {
    private String queryString;
    private String resultType;


}
