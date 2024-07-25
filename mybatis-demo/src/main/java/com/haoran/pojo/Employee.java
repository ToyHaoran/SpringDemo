package com.haoran.pojo;


import lombok.Data;

@Data
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

    // 如果有其他构造器，必须提供无参构造，否则报错。要么一个构造器也没有。
    // public Employee() {}
}