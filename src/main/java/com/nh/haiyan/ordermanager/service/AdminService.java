package com.nh.haiyan.ordermanager.service;

import com.nh.haiyan.ordermanager.bean.Admin;


/**
 * @Classname AdminService
 * @Description TODO
 * @Date 2019/7/30 4:59 PM
 * @Created by nihui
 */
public interface AdminService {

    //public UserAdmin findByUsername(String useranme);
    public Admin findByUsername(String useranme);
}
