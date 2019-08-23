package com.nh.haiyan.ordermanager.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Classname Menu
 * @Description TODO
 * @Date 2019/8/22 8:05 PM
 * @Created by nihui
 */

@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(generator = "UUID")
    private String menuId;
    @NotEmpty(message = "菜单名称不能为空")
    private String menuName;
    @Column(columnDefinition = "enum('menu','auth','button')")
    private String menuType;
    @NotEmpty(message = "菜单URL不能为空")
    private String menuUrl;
    @NotEmpty(message = "菜单标识不能为空")
    private String menuCode;
    @NotEmpty(message = "父菜单ID不能为空")
    private String parentId;
    private String parentIds;
    private Integer childsNum;
    private Short listorder;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    @Transient
    private List<Menu> children;

//    @Transient
//    private List<> roleList;

    @Transient
    private List<Admin> adminList;





}
