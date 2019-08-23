package com.nh.haiyan.ordermanager.bean;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @Classname UserAdmin
 * @Description TODO
 * @Date 2019/7/30 5:16 PM
 * @Created by nihui
 */
@Deprecated
@Getter
@Setter
public class UserAdmin {

    private Long id;
    private Long code;
    private Integer status;
    private Integer is_delete;
    private Date create_time;
    private Date last_update_time;
    private String user_name;
    private String mobile_num;
    private String mail;
    private String encrypt_type;
    private String public_salt;
    private String password;
    private String domain;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Date last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEncrypt_type() {
        return encrypt_type;
    }

    public void setEncrypt_type(String encrypt_type) {
        this.encrypt_type = encrypt_type;
    }

    public String getPublic_salt() {
        return public_salt;
    }

    public void setPublic_salt(String public_salt) {
        this.public_salt = public_salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
