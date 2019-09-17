package com.nh.haiyan.ordermanager.controller;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllProcessResp;
import com.nh.haiyan.ordermanager.service.ProcessQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/processQuery")
public class ProcessQueryController {

    @Autowired
    private ProcessQueryService processQueryService;

    @RequestMapping("/getProcessById")
    public @ResponseBody
    List<GetAllProcessResp> getProcessById(String id){
        List<GetAllProcessResp> list = processQueryService.getProcessById(id);
        return list;
    }

    @RequestMapping("/getProcessInfo")
    public @ResponseBody
    List<GetAllProcessResp> getProcessInfo(){
        List<GetAllProcessResp> list = processQueryService.getProcessInfo();
        return list;
    }
}
