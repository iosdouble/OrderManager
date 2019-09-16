package com.nh.haiyan.ordermanager.service;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllDetailResp;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllManageResp;

import java.util.List;

public interface ManageQueryService {

    List<GetAllManageResp> getManageById(String id);

    List<GetAllManageResp> getManageAll();


}
