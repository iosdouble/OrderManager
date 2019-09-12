package com.nh.haiyan.ordermanager.config.filter;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname ShiroExceptionFilter
 * @Description TODO
 * @Date 2019/7/30 3:11 PM
 * @Created by nihui
 */
public class ShiroExceptionFilter implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof UnauthenticatedException){
            ModelAndView mv = new ModelAndView("shiro_403");
            return mv;
        }
        return null;
    }
}
