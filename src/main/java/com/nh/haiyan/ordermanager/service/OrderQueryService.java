package com.nh.haiyan.ordermanager.service;

import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.bean.QueryServiceParam;

import java.util.List;

/**
 * @Classname OrderQueryService
 * @Description TODO
 * @Date 2019/8/26 9:51 AM
 * @Created by nihui
 */
@Deprecated
public interface OrderQueryService {

    List<GetAllResApplyResp> listAllResApplies(QueryServiceParam queryServiceParam);

    PageInfo<GetAllResApplyResp> pageAllResApplies(QueryServiceParam queryServiceParam,int offset,int limit);

    GetAllResApplyResp getResApplyById(String id);
}
