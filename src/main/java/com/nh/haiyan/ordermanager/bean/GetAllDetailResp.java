package com.nh.haiyan.ordermanager.bean;

import com.nh.haiyan.ordermanager.bean.base.AbsJsonResp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllDetailResp extends AbsJsonResp {
    private Long id;
    private Long ids;
    private String detail;
    private String result;
}
