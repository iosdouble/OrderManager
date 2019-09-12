package com.nh.haiyan.ordermanager.pages.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.nh.haiyan.ordermanager.bean.Detail;
import com.nh.haiyan.ordermanager.bean.GetAllDetailResp;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.pages.service.DetailQueryService;
import com.nh.haiyan.ordermanager.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/detailQuery")
public class DetailQueryController {

    @Autowired
    private DetailQueryService detailQueryService;

    @RequestMapping("/getDetailInfo")
    public @ResponseBody
    List<GetAllDetailResp> getAllDetail(Long orderId) {
        List<GetAllDetailResp> list = detailQueryService.listAllResDetail(orderId); //根据id查询到对象数据
        String list1 = detailQueryService.listAllResDetail(orderId).get(0).getDetail(); //获取到detail字符串
        System.out.println("list1"+list1);
        //GetAllDetailResp detail = JsonUtil.toObject(list1,GetAllDetailResp.class); //将detail的字符串转化为detail对象
        //System.out.println(detail.getApplyUserDomainAccount()+"wwwww");
        return list;
    }
}
