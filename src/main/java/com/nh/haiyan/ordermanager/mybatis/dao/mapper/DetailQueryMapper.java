package com.nh.haiyan.ordermanager.mybatis.dao.mapper;

import com.nh.haiyan.ordermanager.bean.GetAllDetailResp;
import com.nh.haiyan.ordermanager.bean.GetAllResApplyResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailQueryMapper {
    List<GetAllDetailResp> getDetailById(Long id);
}
