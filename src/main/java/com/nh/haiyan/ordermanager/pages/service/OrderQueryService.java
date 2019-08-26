package com.nh.haiyan.ordermanager.pages.service;

import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.bean.QueryServiceParam;

import java.util.List;

/**
 * @Classname OrderQueryService
 * @Description TODO
 * @Date 2019/8/26 9:51 AM
 * @Created by nihui
 */
public interface OrderQueryService {

    List<GetAllResApplyResp> listAllResApplies(QueryServiceParam queryServiceParam);

    PageInfo<GetAllResApplyResp> pageAllResApplies(QueryServiceParam queryServiceParam,int offset,int limit);
}
