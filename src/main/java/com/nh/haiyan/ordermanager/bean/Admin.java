package com.nh.haiyan.ordermanager.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Classname Admin
 * @Description TODO
 * @Date 2019/8/22 4:42 PM
 * @Created by nihui
 */
@Getter
@Setter
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String public_salt;
    private Integer status;

}
