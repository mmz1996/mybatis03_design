package com.mmz.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/4/30 8:49
 * @Created by mmz
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
