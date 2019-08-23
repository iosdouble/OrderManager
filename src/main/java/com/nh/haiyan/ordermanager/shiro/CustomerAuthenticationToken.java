package com.nh.haiyan.ordermanager.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @Classname CustomerAuthenticationToken
 * @Description TODO
 * @Date 2019/7/30 4:52 PM
 * @Created by nihui
 */
public class CustomerAuthenticationToken extends UsernamePasswordToken {

    private String captcha;

    /**
     * 区分前后台登陆
     */
    private String loginTpye;

    /**
     * 区分用户登陆渠道
     */
    private String loginForm;

    private String token;

    public CustomerAuthenticationToken(String username,String password,boolean rememberMe){
        super(username,password,rememberMe);
    }

    public CustomerAuthenticationToken(String token,String loginTpye){
        this.token = token;
        this.loginTpye = loginTpye;
    }


    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getLoginTpye() {
        return loginTpye;
    }

    public void setLoginTpye(String loginTpye) {
        this.loginTpye = loginTpye;
    }

    public String getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(String loginForm) {
        this.loginForm = loginForm;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        if (this.token!=null){
            return token;
        }else {
            return this.getUsername();
        }
    }

    @Override
    public Object getCredentials() {
        if (this.token!=null){
            return this.token;
        }else {
            return this.getPassword();
        }
    }
}
