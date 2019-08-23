package com.nh.haiyan.ordermanager;

import com.nh.haiyan.ordermanager.filter.ShiroExceptionFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class OrdermanagerApplication {
    private static final Logger logger = LogManager.getLogger(OrdermanagerApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(OrdermanagerApplication.class, args);
        logger.info("================启动完成=============");
    }

    @Bean
    public ShiroExceptionFilter myExceptionResolver(){
        return new ShiroExceptionFilter();
    }
}
