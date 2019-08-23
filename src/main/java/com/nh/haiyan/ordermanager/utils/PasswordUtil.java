package com.nh.haiyan.ordermanager.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Classname PasswordUtil
 * @Description TODO 密码生成工具
 * @Date 2019/8/22 6:34 PM
 * @Created by nihui
 */
public class PasswordUtil {
    public  static String createAdminPwd(String password,String salt){
        return new SimpleHash("md5",password,ByteSource.Util.bytes(salt),1).toHex();
    }

    public static String createCustomPwd(String password,String salt){
        return new SimpleHash("md5",password,ByteSource.Util.bytes(salt),1).toHex();
    }


    //faab060a9cbc04b8167d213afd586232
    //fcea920f7412b5da7be0cf42b8c93759
//    public static void main(String[] args) {
//        System.out.println(createAdminPwd("123456","asda"));
//        System.out.println(createCustomPwd("123456","asda"));
//    }
}
