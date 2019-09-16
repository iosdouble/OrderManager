package com.nh.haiyan.ordermanager.mybatis.dao.mapper;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllDetailResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailQueryMapper {
    List<GetAllDetailResp> getDetailById(String id);

    List<GetAllDetailResp> getAllDetail();
}
