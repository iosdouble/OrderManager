package com.nh.haiyan.ordermanager.utils;

import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

/**
 * @Classname ReturnUtil
 * @Description TODO 用户JSON格式数据统一
 * @Date 2019/8/23 10:12 AM
 * @Created by nihui
 */

public class ReturnUtil {

    //操作成功部分

    public static ModelMap Success(String msg,Object obj,String referer){
        msg = StringUtils.isEmpty(msg)?"操作成功":msg;
        ModelMap mp = new ModelMap();
        mp.put("status",1);
        mp.put("state","success");
        mp.put("msg",msg);
        mp.put("referer",referer);
        mp.put("result",obj);
        return mp;
    }

    public static ModelMap Success(String msg,Object obj){
        msg = StringUtils.isEmpty(msg)?"操作成功":msg;
        ModelMap mp = new ModelMap();
        mp.put("status",1);
        mp.put("state","success");
        mp.put("msg",msg);
        mp.put("referer",null);
        mp.put("result",obj);
        return mp;
    }


    public static ModelMap Success(String msg){
        msg = StringUtils.isEmpty(msg)?"操作成功":msg;
        ModelMap mp = new ModelMap();
        mp.put("status",1);
        mp.put("state","success");
        mp.put("msg",msg);
        mp.put("referer",null);
        mp.put("result",null);
        return mp;
    }


    //操作失败部分


    public static ModelMap Error(String msg,Object obj,String referer){
        msg = StringUtils.isEmpty(msg)?"操作失败":msg;
        ModelMap mp = new ModelMap();
        mp.put("status",1);
        mp.put("state","error");
        mp.put("msg",msg);
        mp.put("referer",referer);
        mp.put("result",obj);
        return mp;
    }

    public static ModelMap Error(String msg,Object obj){
        msg = StringUtils.isEmpty(msg)?"操作失败":msg;
        ModelMap mp = new ModelMap();
        mp.put("status",1);
        mp.put("state","error");
        mp.put("msg",msg);
        mp.put("referer",null);
        mp.put("result",obj);
        return mp;
    }


    public static ModelMap Error(String msg){
        msg = StringUtils.isEmpty(msg)?"操作失败":msg;
        ModelMap mp = new ModelMap();
        mp.put("status",1);
        mp.put("state","error");
        mp.put("msg",msg);
        mp.put("referer",null);
        mp.put("result",null);
        return mp;
    }
}
