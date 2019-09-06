package com.nh.haiyan.ordermanager.pages.controller;

import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.bean.QueryServiceParam;
import com.nh.haiyan.ordermanager.pages.service.NewOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/orderQuery")
public class OrderQueryController {

    @Autowired
    private NewOrderQueryService newOrderQueryService;

//    @GetMapping("/getOrderById/{id}")
//    public String getOrderQueryById(@PathVariable Long id,  Model model){
//        GetAllResApplyResp getAllResApplyResp = newOrderQueryService.getOrderById(id);
//        model.addAttribute("orderQuery",getAllResApplyResp);
//        System.out.println("获取到的信息为："+getAllResApplyResp);
//        return "../pages/orderQuery/orderQuery";
//    }


    @RequestMapping("/getInfoBymoduleTyep")
    public @ResponseBody
    List<GetAllResApplyResp> pageAllResApplies(Long orderId){

//        PageInfo<GetAllResApplyResp> pageInfo =null;
////        pageInfo = newOrderQueryService.pageAllResApplies(orderId,1,10);
////        return pageInfo.getList() ;
        return newOrderQueryService.listAllResApplies(orderId);
    }





}
