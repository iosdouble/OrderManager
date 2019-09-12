package com.nh.haiyan.ordermanager.controller.base;

import com.alibaba.fastjson.JSON;
import com.nh.haiyan.ordermanager.bean.Admin;
import com.nh.haiyan.ordermanager.service.base.LogService;
import com.nh.haiyan.ordermanager.shiro.ShiroUtil;
import com.nh.haiyan.ordermanager.utils.IpUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Classname PublicController
 * @Description TODO 公共模块管理
 * @Date 2019/8/22 4:32 PM
 * @Created by nihui
 */
@Controller
@RequestMapping(value = "/")
public class PublicController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static long LOGIN_TIME_OUT = 3600*1000; //登陆超时时间

    //记录登陆日志
    @Autowired
    private LogService logService;

    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(){
        if (ShiroUtil.isLogin()){
            return "redirect:/index";
        }
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody String login(@RequestBody Admin admin, HttpSession httpSession, HttpServletRequest request){
        String flag = "false";
        String username = admin.getUsername();
        String password = admin.getPassword();

        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            flag = "用户或者密码为空";
            return JSON.toJSONString(flag);
        }
//        CustomerAuthenticationToken token = new CustomerAuthenticationToken(username,password,false);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        token.setLoginForm("1");
        System.out.println(token.getPassword());
        Subject currentUser = SecurityUtils.getSubject();

        System.out.println();
        try {
            logger.info("对用户["+username+"]进行登陆验证.验证开始");
            currentUser.login(token);
            flag = "success";
            logger.info("对用户["+username+"]进行登陆验证.验证通过");
        }catch (UnknownAccountException uae){
            logger.info("对用户["+username+"]进行登陆验证.验证未通过,未知账户");
            flag = "未知账户";
        }catch (IncorrectCredentialsException ice){
            ice.printStackTrace();
            logger.info("对用户["+username+"]进行登陆验证.验证未通过,错误的凭证");
            flag = "密码不正确";
        }catch (LockedAccountException lae){
            logger.info("对用户["+username+"]进行登陆验证.验证未通过,账户已锁定");
            flag = "账户已锁定";
        }catch (ExcessiveAttemptsException eae){
            logger.info("对用户["+username+"]进行登陆验证.验证未通过,错误次数过多");
            flag = "用户名或密码错误次数过多";
        }catch (AuthenticationException ae){
            logger.info("对用户["+username+"]进行登陆验证.验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            flag = "用户名或密码不正确";
        }

        //验证是否成功
        if (currentUser.isAuthenticated()){
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("loginType","1");
            session.setTimeout(LOGIN_TIME_OUT);
            String ip = IpUtil.getIpAddr(request);
            //记录登陆日志
            //logService.insertLoginLog(username,ip,request.getContextPath());
            return JSON.toJSONString(flag);
        }else {
            token.clear();
            return JSON.toJSONString(flag);
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes){
        logger.info("PublicController.logout()");
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message","您以安全退出");
        return "redirect:/login";
    }



}
