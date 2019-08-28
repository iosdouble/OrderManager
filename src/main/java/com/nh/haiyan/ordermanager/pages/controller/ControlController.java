package com.nh.haiyan.ordermanager.pages.controller;

import com.github.pagehelper.PageInfo;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import com.nh.haiyan.ordermanager.bean.QueryServiceParam;
import com.nh.haiyan.ordermanager.pages.service.impl.OrderQueryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname ControlController
 * @Description TODO 控制管理 Controller层
 * @Date 2019/8/23 10:04 AM
 * @Created by nihui
 */
@Controller
@RequestMapping("/controlController")
public class ControlController {

    private static Logger log = LoggerFactory.getLogger(ControlController.class);

    @Autowired
    private OrderQueryServiceImpl orderQueryService;

    @RequestMapping("/getSel")
    public @ResponseBody List<GetAllResApplyResp> getAllResp(){
        QueryServiceParam queryServiceParam = new QueryServiceParam();
        queryServiceParam.setModuleType("devops");
        queryServiceParam.setApplyStatus(6);
        queryServiceParam.setDeptCode(124L);
        queryServiceParam.setEndApplyDateTime("2019-08-01");
        queryServiceParam.setEndApplyDateTime("2019-08-10");
        return orderQueryService.listAllResApplies(queryServiceParam);
    }

    @RequestMapping("/getInfoBymoduleTyep")
    public @ResponseBody List<GetAllResApplyResp> pageAllResApplies(){
        QueryServiceParam queryServiceParam = new QueryServiceParam();
        queryServiceParam.setModuleType("devops");
        queryServiceParam.setApplyStatus(6);
        queryServiceParam.setDeptCode(124L);
        queryServiceParam.setEndApplyDateTime("2019-08-01");
        queryServiceParam.setEndApplyDateTime("2019-08-10");

        PageInfo<GetAllResApplyResp> pageInfo =null;

        pageInfo = orderQueryService.pageAllResApplies(queryServiceParam,5,10);

        return pageInfo.getList() ;
    }
    @RequestMapping("/getOne/{id}")
    public String getResApplyById(@PathVariable String id, Model model){
        System.out.println("#####################");
        GetAllResApplyResp getAllResApplyResp =  orderQueryService.getResApplyById(id);
        model.addAttribute("list1",getAllResApplyResp);
        return "";
    }
}
