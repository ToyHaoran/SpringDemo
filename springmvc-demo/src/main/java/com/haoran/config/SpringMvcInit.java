package com.haoran.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 替代web.xml，可以被web项目加载，会初始化ioc容器，设置dispatcherServlet的地址
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override // service mapper层的ioc容器的配置
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override  // 指定springmvc的配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override  // 配置springmvc内部自带servlet的访问地址! 即dispatcherServlet的处理路径!
    protected String[] getServletMappings() {
        return new String[]{"/"};  // "/"代表处理所有请求!
    }
}
