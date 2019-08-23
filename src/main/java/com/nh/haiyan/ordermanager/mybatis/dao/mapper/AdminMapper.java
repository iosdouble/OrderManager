package com.nh.haiyan.ordermanager.mybatis.dao.mapper;


import org.apache.ibatis.annotations.Mapper;

/**
 * @Classname AdminMapper
 * @Description TODO
 * @Date 2019/8/10 2:44 PM
 * @Created by nihui
 */
@Mapper
public interface AdminMapper<Admin> {
    //UserAdmin selectByUsername(String username);
    Admin selectByUsername(String username);
}
