package com.nh.haiyan.ordermanager.utils;

import java.util.UUID;

/**
 * @Classname UuidUtil
 * @Description TODO UUID 工具类
 * @Date 2019/8/23 10:19 AM
 * @Created by nihui
 */
public class UuidUtil {
    public UuidUtil() {
    }

    /**
     * 获取一个UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }


    public static String[] getUUID(int number){
        if (number<1){
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }
}
