package com.haoran.controller;

import com.haoran.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class RestfulController {

    @PostMapping
    public Object save(@RequestBody User user){
        System.out.println("user = " + user);
        System.out.println("用户保存业务!");
        return "{'status':'ok'}";
    }

    @GetMapping("{id}")
    public Object detail(@PathVariable Integer id){
        System.out.println("id = " + id);
        System.out.println("用户详情业务!");
        return "{'status':'ok'}";
    }

    @PutMapping  // 更新业务接口
    public User update(@RequestBody User user){
        return user;
    }

    @DeleteMapping("{id}")  // 删除业务接口
    public User delete(@PathVariable Integer id){
        return null;
    }

    @GetMapping
    public Object page(@RequestParam(required = false,defaultValue = "1") int page,
                       @RequestParam(required = false,defaultValue = "10") int size){
        System.out.println("page = " + page + ", size = " + size);
        System.out.println("分页查询业务!");
        return "{'status':'ok'}";
    }

    @GetMapping("search")  // 模拟条件分页查询业务接口
    public Object search(String keyword,
                             @RequestParam(required = false,defaultValue = "1") int page,
                             @RequestParam(required = false,defaultValue = "10") int size){
        System.out.println("page = " + page + ", size = " + size + ", keyword = " + keyword);
        System.out.println("条件分页查询业务!");
        return "{'status':'ok'}";
    }
}

