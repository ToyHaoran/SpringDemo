package com.haoran.config;

import com.haoran.handler.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc // 自动添加秘书、经理、json处理器 (每个Controller都是一个Handler)
@Configuration
@ComponentScan({"com.haoran.controller", "com.haoran.handler"})  // 1. controller配置ioc容器
public class MvcConfig implements WebMvcConfigurer {
    // implements WebMvcConfigurer web相关，如静态资源、jsp等。

    // @Bean  // 2. 加入到ioc容器，可用@EnableWebMvc替代
    // public RequestMappingHandlerMapping handlerMapping(){
    //     return new RequestMappingHandlerMapping();
    // }
    //
    // @Bean
    // public RequestMappingHandlerAdapter handlerAdapter(){
    //     return new RequestMappingHandlerAdapter();
    // }

    @Override  //视图解析器，指定前后缀
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //registry可以快速添加前后缀
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //开启静态资源查找(二秘书) (CEO去秘书处找，到不到对应handler，也没有找静态资源)
    @Override  // http://localhost:8080/images/toy.jpg
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 先声明的优先级高，在外层。
        registry.addInterceptor(new MyInterceptor())  // 默认拦截全部请求
                .addPathPatterns("/json/**")  // 指定地址拦截 (可选)
                .excludePathPatterns("/json/data1");  // 排除拦截 (可选)
    }
}
