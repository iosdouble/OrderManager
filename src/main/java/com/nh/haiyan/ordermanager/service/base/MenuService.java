package com.nh.haiyan.ordermanager.service.base;

import com.github.pagehelper.PageHelper;
import com.nh.haiyan.ordermanager.bean.Menu;
import com.nh.haiyan.ordermanager.mybatis.dao.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Classname MenuService
 * @Description TODO
 * @Date 2019/8/22 8:00 PM
 * @Created by nihui
 */
@Service
public class MenuService {


    @Autowired
    private MenuMapper<Menu> menuMapper;


    public List<Menu> selectAllMenu() {
       return  menuMapper.selectAllMenu();
    }



    public List<Menu> getChildMenuList(ArrayList<Menu> menuLists, String parentId) {
        HashMap<String,String> condition = new HashMap<>();
        condition.put("parentId",parentId);
        PageHelper.orderBy("listorder asc, create_date desc");
        List<Menu> List = menuMapper.selectByCondition(condition);
        for (Menu menu:List) {
            menuLists.add(menu);

            getChildMenuList(menuLists,menu.getMenuId());
        }
        return menuLists;
    }

    public List<Menu> getMenuAll() {
        PageHelper.orderBy("listorder asc, create_date desc");
        return menuMapper.selectAllMenu();
    }
}
