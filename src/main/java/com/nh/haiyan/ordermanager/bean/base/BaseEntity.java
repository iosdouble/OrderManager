package com.nh.haiyan.ordermanager.bean.base;


import javax.persistence.Transient;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2019/8/22 8:03 PM
 * @Created by nihui
 */
public class BaseEntity {
    @Transient
    private Integer offset = 0;

    @Transient
    private Integer limit = 0;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
