package com.nh.haiyan.ordermanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.ManageQueryMapper;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllDetailResp;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllManageResp;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.service.ManageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManageQueryServiceImpl implements ManageQueryService {

    @Autowired
    private ManageQueryMapper manageQueryMapper;

    @Override
    public List<GetAllManageResp> getManageById(String id) {
        List<GetAllManageResp> result = manageQueryMapper.getManageById(id);
        return result;
    }

    @Override
    public List<GetAllManageResp> getManageAll() {
        List<GetAllManageResp> result = manageQueryMapper.getManageAll();
        return result;
    }
}
