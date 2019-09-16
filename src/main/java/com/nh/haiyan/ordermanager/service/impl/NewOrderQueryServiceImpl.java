package com.nh.haiyan.ordermanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.OrderQueryMapper;
import com.nh.haiyan.ordermanager.service.NewOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewOrderQueryServiceImpl implements NewOrderQueryService {

    @Autowired
    private OrderQueryMapper orderQueryMapper;

    @Override
    public GetAllResApplyResp getOrderById(String id) {
        return null;
    }

    @Override
    public List<GetAllResApplyResp> listAllResApplies(String orderId) {
        List<GetAllResApplyResp> result = orderQueryMapper.getOrderById(orderId);
        return result;
    }

    @Override
    public PageInfo<GetAllResApplyResp> pageAllResApplies(String orderId, int offset, int limit) {
        PageHelper.offsetPage(offset,limit);
        List<GetAllResApplyResp> result = listAllResApplies(orderId);
        PageInfo<GetAllResApplyResp> pageInfo = new PageInfo<>(result);
        return pageInfo ;
    }

}
