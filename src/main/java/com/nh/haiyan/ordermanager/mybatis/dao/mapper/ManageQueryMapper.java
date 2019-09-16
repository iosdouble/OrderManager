package com.nh.haiyan.ordermanager.mybatis.dao.mapper;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllManageResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManageQueryMapper {

    List<GetAllManageResp> getManageById(String id);

    List<GetAllManageResp> getManageAll();

}
