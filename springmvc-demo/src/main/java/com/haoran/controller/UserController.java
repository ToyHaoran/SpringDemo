package com.haoran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")  // 提取相同的访问路径(非必须)，等价/user/xxx
public class UserController {
    // @RequestMapping 将handler注册到handlerMapping
    // 表示对外访问的地址，不必以/开头，不加地址默认/user/方法名。但@WebServlet("必须使用/开头")
    // 精准地址 {"地址1","地址2"}
    // 模糊地址 任意一层/user/*/* 任意层/user/**
    @RequestMapping({"hello","hello2"})
    @ResponseBody  // 直接返回字符串给前端，不要找视图解析器!!!
    public String hello(){
        System.out.println("HelloController.hello");
        return "hello springmvc!!";
    }

    // 指定请求方式，默认任何方式都可以。不符合出现405异常。
    // public enum RequestMethod { GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE }
    @RequestMapping(value = "register", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String register(){
        return "register";
    }

    @GetMapping("login")  // 等价 RequestMapping指定请求方式。只能用在方法上。
    @ResponseBody
    public String login(){
        return "login";
    }
}
