package com.nh.haiyan.ordermanager.mybatis.model;

import com.nh.haiyan.ordermanager.bean.base.AbsJsonResp;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Classname GetAllResApplyResp
 * @Description TODO 获取到所有工单信息
 * @Date 2019/8/26 9:52 AM
 * @Created by nihui
 */
@Getter
@Setter
public class GetAllResApplyResp extends AbsJsonResp {


    private String resApplyId;
    private Long applyUserCode;
    private String applyUserName;
    private Date applyDataTime;
    private Integer applyStatus;
    private String moduleType;
    private Long deptCode;
}
