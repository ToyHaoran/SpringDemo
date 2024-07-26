package com.haoran.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cookie")
@ResponseBody
public class CookieController {

    @RequestMapping("data")  // 获取请求头中的cookie
    public String data(@CookieValue(value = "cookieName") String value){
        System.out.println("value = " + value);
        return value;
    }

    @GetMapping("save")  // 将cookie返回到浏览器
    public String save(HttpServletResponse response){
        Cookie cookie = new Cookie("cookieName","root");
        response.addCookie(cookie);
        return "ok";
    }

    @GetMapping("header")  // 获取请求头
    public String data2(@RequestHeader("Host") String host){
        System.out.println("host = " + host);
        return "host = " + host;
    }
}
