package com.nh.haiyan.ordermanager.pages.service.impl;

import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.OrderQueryMapper;
import com.nh.haiyan.ordermanager.pages.service.NewOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewOrderQueryServiceImpl implements NewOrderQueryService {

    @Autowired
    private OrderQueryMapper orderQueryMapper;
    @Override
    public GetAllResApplyResp getOrderById(Long id) {
        return orderQueryMapper.getOrderById(id);
    }
}
