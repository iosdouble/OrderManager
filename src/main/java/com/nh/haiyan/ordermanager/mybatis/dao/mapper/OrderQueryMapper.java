package com.nh.haiyan.ordermanager.mybatis.dao.mapper;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Classname OrderQueryMapper
 * @Description TODO
 * @Date 2019/9/6 4:22 PM
 * @Created by nihui
 */
@Mapper
public interface OrderQueryMapper {
    List<GetAllResApplyResp> getOrderById(String orderId);

    List<GetAllResApplyResp> getAllOrder();
}
