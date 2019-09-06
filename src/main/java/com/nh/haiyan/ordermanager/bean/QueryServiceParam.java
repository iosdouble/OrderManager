package com.nh.haiyan.ordermanager.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Classname QueryServiceParam
 * @Description TODO 获取工单参数
 * @Date 2019/8/26 10:57 AM
 * @Created by nihui
 */

@Deprecated
@Setter
@Getter
public class QueryServiceParam {
    private String moduleType;
    private Long deptCode;
    private Integer applyStatus;
    private String startApplyDateTime;
    private String endApplyDateTime;
}
