package com.nh.haiyan.ordermanager.service.impl;

import com.nh.haiyan.ordermanager.mybatis.dao.mapper.ProcessQueryMapper;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllProcessResp;
import com.nh.haiyan.ordermanager.service.ProcessQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessQueryServiceImpl implements ProcessQueryService {

    @Autowired
    private ProcessQueryMapper processQueryMapper;
    @Override
    public List<GetAllProcessResp> getProcessById(String id) {
        List<GetAllProcessResp> result = processQueryMapper.getProcessById(id);
        return result;
    }

    @Override
    public List<GetAllProcessResp> getProcessInfo() {
        List<GetAllProcessResp> result = processQueryMapper.getProcessInfo();
        return result;
    }
}
