package com.haoran.controller;

import com.haoran.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("param")
@ResponseBody  // 所有方法都返回字符串给前端，不要找视图解析器!!!
public class ParamController {

    // 直接接收 /param/data?name=root&age=28
    // 要求：名称相同，不传递参数报错，需要内部处理。(引用类型可以不传递，null)
    @RequestMapping("data")
    public String data(String name,int age){
        System.out.println("/param/data()");
        return "name = " + name + ", age = " + age;
    }

    // RequestParam注解指定：指定任意的请求参数名。 /param/data1?name=root
    @GetMapping("data1")
    public String data1(@RequestParam(value = "name") String name, // 形参名和请求参数名一致，可以省略value
                        @RequestParam(required = false, defaultValue = "18") int age){
        System.out.printf("/param/data1()");
        return "name = " + name + ", age = " + age;
    }

    // 一key多值使用集合接值，/param/data2?key=1&key=2
    // 不加注解@RequestParam将key对应的一个字符串直接赋值给集合！类型异常！
    @GetMapping("data2")
    public String data2(@RequestParam List<String> key){
        System.out.println("keys = " + key);
        return "ok";
    }

    // 重点：使用实体对象接值 /param/data3?name=lisi&age=28
    @RequestMapping("data3")
    public String data3(User user){
        System.out.println("user = " + user);
        return user.toString();
    }
}
