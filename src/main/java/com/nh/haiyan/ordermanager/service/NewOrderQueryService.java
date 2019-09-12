package com.nh.haiyan.ordermanager.service;

import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;

import java.util.List;

public interface NewOrderQueryService {

    GetAllResApplyResp getOrderById(Long id);

    List<GetAllResApplyResp> listAllResApplies(Long orderId);

    PageInfo<GetAllResApplyResp> pageAllResApplies(Long orderId, int offset, int limit);

}
