package com.nh.haiyan.ordermanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.bean.QueryServiceParam;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.ext.OrderQueryMapperExt;
import com.nh.haiyan.ordermanager.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname OrderQueryServiceImpl
 * @Description TODO
 * @Date 2019/8/26 11:00 AM
 * @Created by nihui
 */
@Deprecated
@Service
public class OrderQueryServiceImpl implements OrderQueryService {


    @Autowired
    private OrderQueryMapperExt orderQueryMapperExt;

    @Override
    public List<GetAllResApplyResp> listAllResApplies(QueryServiceParam queryServiceParam) {
        String moduleType = queryServiceParam.getModuleType();
        Long deptCode = queryServiceParam.getDeptCode();
        Integer applyStatus = queryServiceParam.getApplyStatus();
        String startApplyDateTime = queryServiceParam.getStartApplyDateTime();
        String endApplyDateTime = queryServiceParam.getEndApplyDateTime();

        List<GetAllResApplyResp> result = orderQueryMapperExt.listAllResApplies(moduleType,deptCode,applyStatus,startApplyDateTime,endApplyDateTime);

        return result;
    }

    @Override
    public PageInfo<GetAllResApplyResp> pageAllResApplies(QueryServiceParam queryServiceParam, int offset, int limit) {
        PageHelper.offsetPage(offset,limit);
        List<GetAllResApplyResp> result = listAllResApplies(queryServiceParam);
        PageInfo<GetAllResApplyResp> pageInfo = new PageInfo<>(result);
        return pageInfo ;
    }

    @Override
    public GetAllResApplyResp getResApplyById(String id) {
        return orderQueryMapperExt.getResApplyById(id);
    }


}
