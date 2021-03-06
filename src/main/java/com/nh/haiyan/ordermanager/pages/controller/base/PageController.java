package com.nh.haiyan.ordermanager.pages.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname PageController
 * @Description TODO 页面跳转控制器
 * @Date 2019/8/22 4:21 PM
 * @Created by nihui
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String home(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "control/control";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/control")
    public String control(){
        return "control/control";
    }




    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
