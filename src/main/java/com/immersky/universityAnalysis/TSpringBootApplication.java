package com.immersky.universityAnalysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目启动类入口
 *
 * 配置文件说明：
 * SpringBoot配置文件地址：    resources/application.properties
 * log日志配置文件地址：     resources/log4j2.xml
 */
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.immersky.universityAnalysis.dao")
public class TSpringBootApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TSpringBootApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TSpringBootApplication.class,args);
    }
}
