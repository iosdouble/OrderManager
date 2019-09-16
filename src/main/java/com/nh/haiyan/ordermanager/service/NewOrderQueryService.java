package com.nh.haiyan.ordermanager.service;

import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;

import java.util.List;

public interface NewOrderQueryService {

    GetAllResApplyResp getOrderById(String id);

    List<GetAllResApplyResp> listAllResApplies(String orderId);

    PageInfo<GetAllResApplyResp> pageAllResApplies(String orderId, int offset, int limit);

}
