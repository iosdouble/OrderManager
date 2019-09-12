package com.nh.haiyan.ordermanager.service.impl;

import com.nh.haiyan.ordermanager.bean.Admin;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.AdminMapper;
import com.nh.haiyan.ordermanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname AdminServiceImpl
 * @Description TODO
 * @Date 2019/8/10 2:46 PM
 * @Created by nihui
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper<Admin> adminMapper;

    @Override
    public Admin findByUsername(String useranme) {
        System.out.println(useranme);
        return adminMapper.selectByUsername(useranme);
    }
}
