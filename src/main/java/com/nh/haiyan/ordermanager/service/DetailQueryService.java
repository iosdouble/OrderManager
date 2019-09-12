package com.nh.haiyan.ordermanager.service;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllDetailResp;

import java.util.List;

public interface DetailQueryService {
    GetAllDetailResp getDetailById(Long id);

    List<GetAllDetailResp> listAllResDetail(Long orderId);

    List<GetAllDetailResp> getAllResDetail();
}
