package com.nh.haiyan.ordermanager.controller;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.service.NewOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/orderQuery")
public class OrderQueryController {

    @Autowired
    private NewOrderQueryService newOrderQueryService;

    @RequestMapping("/getInfoBymoduleTyep")
    public @ResponseBody
    List<GetAllResApplyResp> pageAllResApplies(String orderId){

//        PageInfo<GetAllResApplyResp> pageInfo =null;
////        pageInfo = newOrderQueryService.pageAllResApplies(orderId,1,10);
////        return pageInfo.getList() ;
        return newOrderQueryService.listAllResApplies(orderId);
    }





}
