package com.nh.haiyan.ordermanager.bean.base;

import com.alibaba.druid.support.json.JSONUtils;
import com.nh.haiyan.ordermanager.utils.JsonUtil;

/**
 * @Classname AbsJsonResp
 * @Description TODO
 * @Date 2019/8/26 9:54 AM
 * @Created by nihui
 */
public class AbsJsonResp implements IResp {


    @Override
    public String toJson() {
        return JsonUtil.toJsonAndLongToString(this);
    }

    @Override
    public String toString() {
        return this.toJson();
    }
}
