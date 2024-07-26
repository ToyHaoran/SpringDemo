package com.haoran.pojo;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class User {
    private String name;  //属性必须等于参数名
    private int age = 18;
}
