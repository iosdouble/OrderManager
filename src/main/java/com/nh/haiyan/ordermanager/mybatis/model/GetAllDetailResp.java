package com.nh.haiyan.ordermanager.mybatis.model;

import com.nh.haiyan.ordermanager.bean.base.AbsJsonResp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllDetailResp extends AbsJsonResp {
    private String id;
    private Long ids;
    private String detail;
    private String result;
}
