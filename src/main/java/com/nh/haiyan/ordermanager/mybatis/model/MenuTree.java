package com.nh.haiyan.ordermanager.mybatis.model;

import com.nh.haiyan.ordermanager.bean.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname MenuTree
 * @Description TODO
 * @Date 2019/8/23 10:46 AM
 * @Created by nihui
 */
public class MenuTree {
    
    private List<Menu> nodes;
   
    //可扩展用户角色菜单
    private List<RoleMenu> checknodes;
    
    public MenuTree(List<Menu> nodes){
        this.nodes = nodes;
    }
    public MenuTree(List<Menu> nodes,List<RoleMenu> checknodes){
        this.nodes = nodes;
        this.checknodes = checknodes;
    }
    
    public List<Map<String,Object>> buildTree(){
        List<Map<String,Object>> list = new ArrayList<>();
        for (Menu node : nodes){
            if ("0".equals(node.getParentId())){
                Map<String,Object> map = buildTreeChildsMap(node);
                list.add(map);
            }
        }
        return list;
    }



    private List<Map<String,Object>> buildTreeChilds(Menu node) {
        List<Map<String,Object>> list = new ArrayList<>();
        List<Menu> childNodes = getChilds(node);
        for (Menu childNode:childNodes) {
            Map<String,Object> map = buildTreeChildsMap(childNode);
            list.add(map);

        }
        return list;
    }




    private Map<String,Object> buildTreeChildsMap(Menu childNode) {

        Map<String,Object> map = new HashMap<>();
        Map<String,Object> stareMap = new HashMap<>();

        stareMap.put("checked",false);
        for (RoleMenu checknode:checknodes){
            if (checknode.getMenuId().equals(childNode.getMenuId())){
                stareMap.put("checked",true);
            }
        }
        stareMap.put("disabled",false);
        stareMap.put("expanded",false);
        stareMap.put("selected",false);
        map.put("id",childNode.getMenuId());
        map.put("text",childNode.getMenuName());
        map.put("url",childNode.getMenuUrl());
        map.put("state",stareMap);
        List<Map<String,Object>> childs = buildTreeChilds(childNode);
        if (childs.isEmpty()||childs.size()==0){

        }else {
            map.put("nodes",childs);
        }
        return map;
    }


    public List<Menu> getChilds(Menu parentNode){
        List<Menu> childNodes = new ArrayList<>();
        for (Menu node:nodes) {
            if (node.getParentId().equals(parentNode.getMenuId())){
                childNodes.add(node);
            }
        }
        return childNodes;
    }

    public List<Menu> buildTreeGrid(){
        List<Menu> list = new ArrayList<>();
        for (Menu node:nodes) {
            if ("0".equals(node.getParentId())){
                List<Menu> childs = buildTreeGridChilds(node);
                node.setChildren(childs);
                list.add(node);
            }
        }
        return list;
    }

    private List<Menu> buildTreeGridChilds(Menu node) {
        List<Menu> list = new ArrayList<>();
        List<Menu> childNodes = getChilds(node);
        for (Menu childNode:childNodes) {
            List<Menu> childs = buildTreeGridChilds(childNode);
            childNode.setChildren(childs);
            list.add(childNode);
        }
        return list;
    }
}
