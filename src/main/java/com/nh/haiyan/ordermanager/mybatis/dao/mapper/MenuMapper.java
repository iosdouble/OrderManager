package com.nh.haiyan.ordermanager.mybatis.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Classname MenuMapper
 * @Description TODO
 * @Date 2019/8/23 10:40 AM
 * @Created by nihui
 */
@Mapper
public interface MenuMapper<Menu> {
    Set<String> findMenuCodeByUserId(String userId);

    Set<String> getAllMenuCode();

    List<Menu> selectAllMenu();

    List<Menu> selectByCondition(HashMap<String,String> condition);
}
