package com.nh.haiyan.ordermanager.controller;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllDetailResp;
import com.nh.haiyan.ordermanager.service.DetailQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/detailQuery")
public class DetailQueryController {

    @Autowired
    private DetailQueryService detailQueryService;

    @RequestMapping("/getDetailInfo")
    public @ResponseBody
    List<GetAllDetailResp> getAllDetail(String orderId) {
        List<GetAllDetailResp> list = detailQueryService.listAllResDetail(orderId); //根据id查询到对象数据
        //GetAllDetailResp detail = JsonUtil.toObject(list1,GetAllDetailResp.class); //将detail的字符串转化为detail对象
        //System.out.println(detail.getApplyUserDomainAccount()+"wwwww");
        System.out.println(list);
        return list;
    }


    @RequestMapping("/getAllInfo")
    public @ResponseBody
    List<GetAllDetailResp> getAllInfo() {
        List<GetAllDetailResp> list = detailQueryService.getAllResDetail(); //根据id查询到对象数据
        //GetAllDetailResp detail = JsonUtil.toObject(list1,GetAllDetailResp.class); //将detail的字符串转化为detail对象
        //System.out.println(detail.getApplyUserDomainAccount()+"wwwww");
        System.out.println(list);
        return list;
    }


}
