package com.haoran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@EnableWebMvc // 自动添加秘书、经理、json处理器
@Configuration
@ComponentScan("com.haoran.controller")  // 1. controller配置ioc容器
public class MvcConfig {

    // @Bean  // 2. handlerMapping  handlerAdapter加入到ioc容器
    // public RequestMappingHandlerMapping handlerMapping(){
    //     return new RequestMappingHandlerMapping();
    // }
    //
    // @Bean
    // public RequestMappingHandlerAdapter handlerAdapter(){
    //     return new RequestMappingHandlerAdapter();
    // }

}
