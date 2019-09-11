package com.nh.haiyan.ordermanager.pages.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
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
        System.out.println(detailQueryService.listAllResDetail(orderId)+"11111");
        return detailQueryService.listAllResDetail(orderId);
    }
}
