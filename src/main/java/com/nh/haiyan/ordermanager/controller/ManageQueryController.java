package com.nh.haiyan.ordermanager.controller;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllManageResp;
import com.nh.haiyan.ordermanager.service.ManageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manageQuery")
public class ManageQueryController {

    @Autowired
    private ManageQueryService manageQueryService;

    @RequestMapping("/getManageById")
    public @ResponseBody List<GetAllManageResp> getManageById(Long id){
        List<GetAllManageResp> resp = manageQueryService.getManageById(id);
        return resp;
    }

    @RequestMapping("/getManageInfo")
    public  @ResponseBody
    List<GetAllManageResp> getAllManage(Model model){
        List<GetAllManageResp> list = manageQueryService.getManageAll();
        model.addAttribute("list",list);
        System.out.println("1111"+list);
        return list;

    }
}
