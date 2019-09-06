package com.nh.haiyan.ordermanager.mybatis.dao.mapper;

import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;

/**
 * @Classname OrderQueryMapper
 * @Description TODO
 * @Date 2019/9/6 4:22 PM
 * @Created by nihui
 */
public interface OrderQueryMapper {

    GetAllResApplyResp getOrderById(Long id);
}
