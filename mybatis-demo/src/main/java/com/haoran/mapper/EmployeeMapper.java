package com.haoran.mapper;

import com.haoran.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //根据id查询员工对象
    Employee queryById(Integer id);
    //根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);
    //根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(String name, Double salary);
    // 返回工资最高的员工的姓名和他的工资
    List<Map<String,Object>> queryEmpNameAndMaxSalary();
    int queryCount();

    //插入员工数据
    int insertEmp(Employee employee);
    //插入员工数据，传入的是一个map(name=员工的名字,salary=员工的薪水)
    int insertEmpMap(Map data);

    //根据id删除员工信息
    int deleteById(Integer id);

}
