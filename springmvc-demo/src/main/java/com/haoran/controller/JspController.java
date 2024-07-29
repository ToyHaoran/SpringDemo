package com.haoran.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

    // 快速查找试图
    // 1. 方法的返回值是字符串类型
    // 2. 不能添加@ResponseBody(直接返回给字符串给浏览器，不走视图解析器)
    // 3. 返回值 对应中间的视图名称即可  /springmvc/jsp/index
    @GetMapping("index")
    public String index(HttpServletRequest request){
        request.setAttribute("data","hello jsp!!!");
        System.out.println("JspController.index");
        return "index";
    }

    // 转发：只能是项目下的资源。
    @GetMapping("forward")
    public String forward(){
        System.out.println("JspController.forward");
        return "forward:/jsp/index";
    }

    // 重定向：属于二次请求，可以是项目外的资源。
    @GetMapping("redirect")
    public String redirect(){
        System.out.println("JspController.redirect");
        return "redirect:/jsp/index";
    }

    @GetMapping("redirect/baidu")
    public String redirectBaidu(){
        System.out.println("JspController.redirectBaidu");
        return "redirect:http://www.baidu.com";
    }
}
