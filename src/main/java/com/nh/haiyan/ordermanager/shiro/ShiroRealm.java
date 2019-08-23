package com.nh.haiyan.ordermanager.shiro;

import com.nh.haiyan.ordermanager.bean.Admin;
import com.nh.haiyan.ordermanager.pages.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Classname ShiroRealm
 * @Description TODO
 * @Date 2019/7/30 4:57 PM
 * @Created by nihui
 */

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //在实际项目中，这里可以根据实际情况做缓存操作。如果没有缓存操作，Shiro有自己的时间隔离机制，2分钟不会重复执行该方法。
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //获取到用户账号通过用户账号获取到用户信息
        String account = (String) token.getPrincipal();

//        UserAdmin userInfo = adminService.findByUsername(account);
        Admin userInfo  =adminService.findByUsername(account);
        if (userInfo==null){
            throw new UnknownAccountException();
        }
        if ("0".equals(userInfo.getStatus().toString())){
            throw new LockedAccountException();
        }

        SecurityUtils.getSubject().getSession().setAttribute("user",userInfo);

        ByteSource credentialsSalt = ByteSource.Util.bytes(userInfo.getPublic_salt());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,
                userInfo.getPassword(),
                credentialsSalt,
                getName());

        return authenticationInfo;
    }

    //这方法是用来做权限认证的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }




}
