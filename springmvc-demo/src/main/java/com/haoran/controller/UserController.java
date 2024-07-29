package com.haoran.controller;

import com.haoran.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")  // 提取相同的访问路径(非必须)，等价/user/xxx
@ResponseBody  // 直接返回字符串给前端，不要找视图解析器!!!
// @RestController = @Controller + @ResponseBody
public class UserController {
    // @RequestMapping 将handler注册到handlerMapping
    // 表示对外访问的地址，不必以/开头，不加地址默认/user/方法名。但@WebServlet("必须使用/开头")
    // 精准地址 {"地址1","地址2"}
    // 模糊地址 任意一层/user/*/* 任意层/user/**
    @RequestMapping({"hello","hello2"})
    public String hello(){
        System.out.println("HelloController.hello");
        return "hello springmvc!!";
    }

    // 指定请求方式，默认任何方式都可以。不符合出现405异常。
    // public enum RequestMethod { GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE }
    @RequestMapping(value = "register", method = {RequestMethod.POST,RequestMethod.GET})
    public String register(){
        return "register";
    }

    @GetMapping("login")  // 等价 RequestMapping指定请求方式。只能用在方法上。
    public String login(){
        return "login";
    }

    @GetMapping("exception")
    public String  exception(){
        System.out.println("UserController.exception");
        int i = 1/0; //除零异常 ArithmeticException
        return "ok";
    }

    // BindingResult紧跟实体类参数，避免参数校验错误信息抛出
    @PostMapping("verify")
    public Object verify(@Validated @RequestBody User user,
                         BindingResult result){
        if (result.hasErrors()){
            System.out.println("参数错误");
            return result.getFieldError().toString();
        }
        System.out.println("参数正常");
        return user;
    }

    // 请求post: {name,age,gender}
    // 415异常是因为Java原生的api只支持路径参数和param参数，不支持json。
    // 解决：导入json处理的依赖，给handlerAdapter配置json转化器
    @PostMapping("json1")
    public String json1(@RequestBody User user){
        System.out.println("user = " + user);
        return user.toString();
    }

    @PostMapping("json2")
    public User json2(@RequestBody User user){
        System.out.println("user = " + user);
        return user;  // 前后端分离模式：user -> 经理 -> json -> @ResponseBody -> 直接返回{}
    }

    @GetMapping("json3")
    public List<User> json3(){
        User user = new User();
        user.setName("two dogs!");
        user.setAge(3);
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;  // 返回集合json [{},{}]
    }

    // 直接接收 /user/param1?name=root&age=28
    // 要求：名称相同，不传递参数报错，需要内部处理。(引用类型可以不传递，null)
    @RequestMapping("param1")
    public String param1(String name,int age){
        System.out.println("/param/data()");
        return "name = " + name + ", age = " + age;
    }

    // RequestParam注解指定：指定任意的请求参数名。 /user/param2?name=root
    @GetMapping("param2")
    public String param2(@RequestParam(value = "name") String name, // 形参名和请求参数名一致，可以省略value
                         @RequestParam(required = false, defaultValue = "18") int age){
        System.out.printf("/param/data1()");
        return "name = " + name + ", age = " + age;
    }

    // 一key多值使用集合接值，/user/param3?key=1&key=2
    // 不加注解@RequestParam将key对应的一个字符串直接赋值给集合！类型异常！
    @GetMapping("param3")
    public String param3(@RequestParam List<String> key){
        System.out.println("keys = " + key);
        return "ok";
    }

    // 重点：使用实体对象接值 /user/param4?name=lisi&age=28
    @RequestMapping("param4")
    public String param4(User user){
        System.out.println("user = " + user);
        return user.toString();
    }

    // 路径传参：/user/path/账号/密码
    @RequestMapping("path/{account}/{password}")
    public String path1(@PathVariable(value = "account") String username, @PathVariable String password){
        System.out.println("username = " + username + ", password = " + password);
        return "username = " + username + ", password = " + password;
    }
}
