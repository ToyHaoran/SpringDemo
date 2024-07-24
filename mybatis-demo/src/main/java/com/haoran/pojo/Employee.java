package com.haoran.pojo;


public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

    // 如果有其他构造器，必须提供无参构造，否则报错。要么一个构造器也没有。
    // public Employee() {}
    //
    // public Employee(String empName, double empSalary) {
    //     this.empName = empName;
    //     this.empSalary = empSalary;
    // }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}