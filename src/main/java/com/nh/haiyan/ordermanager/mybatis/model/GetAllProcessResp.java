package com.nh.haiyan.ordermanager.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetAllProcessResp {

    private String id;
    private String resApplyId;
    private String stepName;
    private Integer stepStatus;
    private Date startTime;
    private Date endTime;
    private String description;
    private String domainAccount;
    private String cnName;
    private String userEmail;
    private Integer isdDeleted;

}
