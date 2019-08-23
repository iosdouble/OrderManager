package com.nh.haiyan.ordermanager.pages.service;

import com.nh.haiyan.ordermanager.bean.Admin;
import com.nh.haiyan.ordermanager.bean.UserAdmin;


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
