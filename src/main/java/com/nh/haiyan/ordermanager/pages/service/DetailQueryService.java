package com.nh.haiyan.ordermanager.pages.service;

import com.nh.haiyan.ordermanager.bean.GetAllDetailResp;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;

import java.util.List;

public interface DetailQueryService {
    GetAllDetailResp getDetailById(Long id);

    List<GetAllDetailResp> listAllResDetail(Long orderId);
}
