package com.nh.haiyan.ordermanager.pages.service.impl;

import com.nh.haiyan.ordermanager.bean.GetAllDetailResp;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.DetailQueryMapper;
import com.nh.haiyan.ordermanager.pages.service.DetailQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailQueryServiceImpl implements DetailQueryService {

    @Autowired
    private DetailQueryMapper detailQueryMapper;
    @Override
    public GetAllDetailResp getDetailById(Long id) {
        return null;
    }

    @Override
    public List<GetAllDetailResp> listAllResDetail(Long orderId) {
        List<GetAllDetailResp> result = detailQueryMapper.getDetailById(orderId);
        return result;
    }
}
