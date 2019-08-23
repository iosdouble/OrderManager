package com.nh.haiyan.ordermanager.pages.controller.base;

import com.nh.haiyan.ordermanager.bean.Admin;
import com.nh.haiyan.ordermanager.bean.Menu;
import com.nh.haiyan.ordermanager.mybatis.model.MenuTree;
import com.nh.haiyan.ordermanager.pages.service.base.MenuService;
import com.nh.haiyan.ordermanager.shiro.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MainController
 * @Description TODO
 * @Date 2019/8/23 9:32 AM
 * @Created by nihui
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MenuService menuService;


    //缺少角色管理

    //缺少管理员登陆

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        Admin admin = ShiroUtil.getUserAdmin();
        List<Menu> treeGridList = this.getMenu(admin);
        model.addAttribute("admin",admin);
        model.addAttribute("menuLists",treeGridList);
        return "/index";
    }

    private List<Menu> getMenu(Admin admin) {
        List<Menu> menuLists = null;
        //判断登陆用户的权限


        menuLists = menuService.selectAllMenu();

        MenuTree menuTreeUtil = new MenuTree(menuLists,null);

        return menuTreeUtil.buildTreeGrid();

//        Menu menu = new Menu();
//        menu.setMenuName("工单查询");
//
//        menuList.add(menu);
//        return menuList;

//        menuList = menuService.selectAllMenu();
//        return null;
    }


}
