package com.nh.haiyan.ordermanager.mybatis.dao.mapper.ext;

import com.nh.haiyan.ordermanager.mybatis.model.GetAllResApplyResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname OrderQueryMapperExt
 * @Description TODO 工单查询扩展接口
 * @Date 2019/8/26 11:01 AM
 * @Created by nihui
 */
@Deprecated
@Mapper
public interface OrderQueryMapperExt {

    @Select("<script>"
            + "select "
            + "id resApplyId, apply_user_code applyUserCode, apply_user_name applyUserName, apply_date_time applyDateTime, apply_status applyStatus, moduleType, dept_code deptCode "
            + "from "
            + "( "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'domain_scan_new' moduleType, dept_code from module_domain_scan_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'kvm_new' moduleType, dept_code from module_kvm_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'db_new' moduleType, dept_code from module_db_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'appDeploy_new' moduleType, dept_code from module_app_deploy_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'net-acl' moduleType, dept_code from module_net_security_policy_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'net-dns' moduleType, dept_code from module_dns_analyze_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'net-lvs' moduleType, dept_code from module_vip_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'cdn_cache_clean_new' moduleType, dept_code from module_cdn_cache_clean_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'cdn_link_up_new' moduleType, dept_code from module_cdn_link_up_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'code_auth_new' moduleType, dept_code from module_code_auth_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'jms' moduleType, dept_code from module_fortress_machine_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'nginx_conf_update_new' moduleType, dept_code from module_nginx_conf_update_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'code_scan_new' moduleType, dept_code from module_code_scan_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'net-gf' moduleType, dept_code from module_domain_high_defense_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'host_scan_new' moduleType, dept_code from module_hostscan_res_apply "
            + "union  "
            + "select id, apply_user_code, apply_user_name, apply_date_time, apply_status, 'custom' moduleType, dept_code from module_custom_res_apply "
            //nihui - 新增加查询语句
            +"union  "
            +"select id,apply_user_code,apply_user_name,apply_date_time,apply_status,'devops' moduleType, dept_code from module_deploy_res_apply "
            //nihui - VPN 延期
            +"union  "
            +"select id,apply_user_code,apply_user_name,apply_date_time,apply_status,'vpnpost' moduleType, dept_code from module_vpn_post_res_apply "
            + ") tmp "
            + "where 1=1 "
            + "<if test='moduleType!=null'>and tmp.moduleType like '${moduleType}' </if> "
            + "<if test='deptCode!=null'>and tmp.dept_code=#{deptCode} </if> "
            + "<if test='applyStatus!=null'>and tmp.apply_status=#{applyStatus} </if> "
            + "<if test='startApplyDateTime!=null'>and tmp.apply_date_time &gt;= '${startApplyDateTime}' </if> "
            + "<if test='endApplyDateTime!=null'>and tmp.apply_date_time &lt;= '${endApplyDateTime}' </if> "
            + "order by applyDateTime desc "
            + "</script>")
    public List<GetAllResApplyResp> listAllResApplies(
            @Param("moduleType") String moduleType,
            @Param("deptCode") Long deptCode,
            @Param("applyStatus") Integer applyStatus,
            @Param("startApplyDateTime") String startApplyDateTime,
            @Param("endApplyDateTime") String endApplyDateTime);



    /*id,apply_status,apply_user_name,dept_code*/
    @Select("<script>"+"select id,dept_code,apply_user_name from module_vip_res_apply where id = #{id}"+"</script>")
    public GetAllResApplyResp getResApplyById(String id);
}
