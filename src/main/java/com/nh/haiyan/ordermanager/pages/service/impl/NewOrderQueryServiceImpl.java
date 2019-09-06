package com.nh.haiyan.ordermanager.pages.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.OrderQueryMapper;
import com.nh.haiyan.ordermanager.pages.service.NewOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewOrderQueryServiceImpl implements NewOrderQueryService {

    @Autowired
    private OrderQueryMapper orderQueryMapper;

    @Override
    public GetAllResApplyResp getOrderById(Long id) {
        return null;
    }

    @Override
    public List<GetAllResApplyResp> listAllResApplies(Long orderId) {
        List<GetAllResApplyResp> result = orderQueryMapper.getOrderById(orderId);
        return result;
    }

    @Override
    public PageInfo<GetAllResApplyResp> pageAllResApplies(Long orderId, int offset, int limit) {
        PageHelper.offsetPage(offset,limit);
        List<GetAllResApplyResp> result = listAllResApplies(orderId);
        PageInfo<GetAllResApplyResp> pageInfo = new PageInfo<>(result);
        return pageInfo ;
    }

}
