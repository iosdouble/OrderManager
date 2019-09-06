package com.nh.haiyan.ordermanager.pages.service;

import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.bean.QueryServiceParam;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewOrderQueryService {

    GetAllResApplyResp getOrderById(Long id);

    List<GetAllResApplyResp> listAllResApplies(Long orderId);

    PageInfo<GetAllResApplyResp> pageAllResApplies(Long orderId, int offset, int limit);

}
