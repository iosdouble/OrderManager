package com.nh.haiyan.ordermanager.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;


/**
 * spring:
 *   datasource:
 *     driverClassName: com.mysql.jdbc.Driver
 *     url: jdbc:mysql://对应自己的数据库连接
 *     username: xxx
 *     password: xxx
 *     druid:
 *       dup-close-log-enable: true
 *
 *
 *
 *
 * ######################### Druid连接池的配置信息  #################
 * #
 * #spring.druid.initialSize: 5                                 #初始化连接大小
 * #spring.druid.minIdle: 5                                     #最小连接池数量
 * #spring.druid.maxActive: 20                                  #最大连接池数量
 * #spring.druid.maxWait: 60000                                 #获取连接时最大等待时间，单位毫秒
 * #spring.druid.timeBetweenEvictionRunsMillis: 60000           #配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
 * #spring.druid.minEvictableIdleTimeMillis: 300000             #配置一个连接在池中最小生存的时间，单位是毫秒
 * #spring.druid.validationQuery: SELECT 1 FROM DUAL            #测试连接
 * #spring.druid.testWhileIdle: true                            #申请连接的时候检测，建议配置为true，不影响性能，并且保证安全性
 * #spring.druid.testOnBorrow: false                            #获取连接时执行检测，建议关闭，影响性能
 * #spring.druid.testOnReturn: false                            #归还连接时执行检测，建议关闭，影响性能
 * #spring.druid.poolPreparedStatements: false                  #是否开启PSCache，PSCache对支持游标的数据库性能提升巨大，oracle建议开启，mysql下建议关闭
 * #spring.druid.maxPoolPreparedStatementPerConnectionSize: 20  #开启poolPreparedStatements后生效
 * #spring.druid.filters: stat,wall,log4j                       #配置扩展插件，常用的插件有=>stat:监控统计  log4j:日志  wall:防御sql注入
 * #spring.druid.connectionProperties: 'druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000'  #通过connectProperties属性来打开mergeSql功能;慢SQL记录
 */

/**
 * @Classname DataSourceConfig
 * @Description TODO
 * @Date 2019/7/30 11:35 AM
 * @Created by nihui
 */
//@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.druid.initialSize}")
    private int initialSize;

    @Value("${spring.druid.minIdle}")
    private int minIdle;

    @Value("${spring.druid.maxActive}")
    private int maxActive;

    @Value("${spring.druid.maxWait}")
    private int maxWait;

    @Value("${spring.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.druid.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.druid.filters}")
    private String filters;

    @Value("{spring.druid.connectionProperties}")
    private String connectionProperties;

    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);   //这里可以做加密处理
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");  //设置ip白名单
//        servletRegistrationBean.addInitParameter("deny","192.168.0.19");//设置ip黑名单，优先级高于白名单
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","root");
        servletRegistrationBean.addInitParameter("loginPassword","root");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
