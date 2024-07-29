package com.haoran.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// SpringMVC拦截器可以出现在3个位置 (对应Javaweb的过滤器，但只能在在SpringMVC外部拦截)
public class MyInterceptor implements HandlerInterceptor {
    // 执行handler之前(步骤5)，如编码格式设置、登录保护、权限处理！！
    @Override   //                              请求对象                      响应对象    要调用的handler
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor.preHandle");
        return true;  // true 放行  false拦截
    }

    // handler执行完毕后(步骤6)！如对结果处理、敏感词汇检查！ modelAndView是返回的视图和共享域数据对象
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle");
    }

    // 整体处理完毕后执行 (CEO响应用户时 步骤10)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
    }
}
