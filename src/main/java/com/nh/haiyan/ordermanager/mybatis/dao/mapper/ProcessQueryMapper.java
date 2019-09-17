package com.nh.haiyan.ordermanager.mybatis.dao.mapper;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllProcessResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProcessQueryMapper {

    List<GetAllProcessResp> getProcessById(String id);

    List<GetAllProcessResp> getProcessInfo();

}
