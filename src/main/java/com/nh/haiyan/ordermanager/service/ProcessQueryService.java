package com.nh.haiyan.ordermanager.service;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllProcessResp;

import java.util.List;

public interface ProcessQueryService {

    List<GetAllProcessResp> getProcessById(String id);

    List<GetAllProcessResp> getProcessInfo();
}
