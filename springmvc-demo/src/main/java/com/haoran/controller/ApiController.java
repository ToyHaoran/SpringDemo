package com.haoran.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RequestMapping("api")
@Controller
public class ApiController {

    @Autowired  // ioc容器获取对应类型实体对象(组件)并自动装配
    private ServletContext servletContext;

    //原生api
    public void data(HttpServletResponse response,
                     HttpServletRequest request,
                     HttpSession session){
        //使用原生对象就可以
        //ServletContext  [1.最大的配置文件 2.全局最大共享域  3.核心api getRealPath]
        //方案1： request获取 session获取
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext1 = session.getServletContext();
        //方案2： ServletContext 会自动装入到ioc容器！ 程序启动servletContext - ioc容器
        //直接全局注入可以
    }

    //springmvc提供的方法： request提供了几种 {了解}
    // model modelMap map modelAndView
    public void data1(Model model){
        model.addAttribute("key","value"); //request
    }
}
