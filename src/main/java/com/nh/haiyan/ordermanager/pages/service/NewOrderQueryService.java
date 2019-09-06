package com.nh.haiyan.ordermanager.pages.service;

import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import org.springframework.stereotype.Service;

public interface NewOrderQueryService {

    GetAllResApplyResp getOrderById(Long id);
}
