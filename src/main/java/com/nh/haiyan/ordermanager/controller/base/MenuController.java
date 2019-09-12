package com.nh.haiyan.ordermanager.controller.base;

import com.nh.haiyan.ordermanager.bean.Menu;
import com.nh.haiyan.ordermanager.mybatis.model.MenuTree;
import com.nh.haiyan.ordermanager.service.base.MenuService;
import com.nh.haiyan.ordermanager.utils.ReturnUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MenuController
 * @Description TODO 菜单管理
 * @Date 2019/8/22 7:58 PM
 * @Created by nihui
 */
@Controller
@RequestMapping("/menu")
@RequiresAuthentication
public class MenuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;

    //缺省一个角色控制

    @RequiresPermissions("menu:index")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        ArrayList<Menu> menuLists = new ArrayList<>();
        List<Menu> Lists = menuService.getChildMenuList(menuLists,"0");
//        Menu menu = new Menu();
//        menu.setMenuName("工单查询");
//
//        List<Menu> Lists = new ArrayList<>();
//        Lists.add(menu);
        model.addAttribute("menus",Lists);
        return "menu/index";
    }


    @RequiresPermissions("menu:index")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ModelMap list(){
        ModelMap map = new ModelMap();
        List<Menu> List = menuService.getMenuAll();
        MenuTree menuTreeUtil = new MenuTree(List,null);
        List<Menu> treeGridList = menuTreeUtil.buildTreeGrid();
        map.put("treeList",treeGridList);
        map.put("total",List.size());
        return ReturnUtil.Success("加载成功",map,null);
    }

}
