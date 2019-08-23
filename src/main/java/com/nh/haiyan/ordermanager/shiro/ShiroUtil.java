package com.nh.haiyan.ordermanager.shiro;

import com.nh.haiyan.ordermanager.bean.Admin;
import com.nh.haiyan.ordermanager.bean.UserAdmin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname ShiroUtil
 * @Description TODO
 * @Date 2019/7/30 5:39 PM
 * @Created by nihui
 */
public class ShiroUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Boolean isLogin(){
        return getSubject().isAuthenticated();
    }

    public static Session getSession(){
        try {
            Session session = getSubject().getSession();
            if (session!=null){
                session = getSubject().getSession();
            }
            if (session!=null){
                return session;
            }
        }catch (InvalidSessionException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Admin getUserAdmin(){
        try{
            if (getSession()!=null){
                Admin admin = (Admin) getSubject().getPrincipals().getPrimaryPrincipal();
                return admin;
            }else {
                return null;
            }
        }catch (Exception e){

        }
        return null;
    }

}
