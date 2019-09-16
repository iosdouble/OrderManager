package com.nh.haiyan.ordermanager.mybatis.model;

import com.nh.haiyan.ordermanager.bean.base.AbsJsonResp;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetAllManageResp extends AbsJsonResp {

    private String id;
    private String moduleName;
    private String sceneCode;
    private String sceneName;
    private String title;
    private Long ids;
    private String toAddress;
    private String detail;
    private Date time;
    private Integer status;
    private String reason;

}
