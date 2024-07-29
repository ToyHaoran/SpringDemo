package com.haoran.pojo;

import jakarta.validation.constraints.Max;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class User {
    private Integer id;
    private String name;  //属性必须等于参数名

    @Max(value = 100, message = "年龄不能大于100")  // 参数校验
    private int age;
    private String gender;
}
