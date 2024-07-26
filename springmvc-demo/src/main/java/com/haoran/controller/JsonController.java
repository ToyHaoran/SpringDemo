package com.haoran.controller;

import com.haoran.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("json")
@Controller
@ResponseBody
public class JsonController {

    // 请求post: {name,age,gender}
    // 415异常是因为Java原生的api只支持路径参数和param参数，不支持json。
    // 解决：导入json处理的依赖，给handlerAdapter配置json转化器
    @PostMapping("data")
    public String data(@RequestBody Person person){
        System.out.println("person = " + person);
        return person.toString();
    }

    @PostMapping("data1")
    public Person data1(@RequestBody Person person){
        System.out.println("person = " + person);
        return person;
    }
}
