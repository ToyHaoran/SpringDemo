package com.haoran.mapper;

import com.haoran.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    // 根据id查询员工对象
    Employee queryById(Integer id);
    // 根据员工姓名和工资查询员工信息
    List<Employee> queryByNameAndSalary(String name, Double salary);
    // 根据工资查询员工信息
    List<Employee> queryBySalary(Double salary);
    // 返回工资最高的员工的姓名和他的工资
    List<Map<String,Object>> queryEmpNameAndMaxSalary();

    // 插入员工数据，主键回显，获取自增长的主键值
    int insertEmp(Employee employee);
    // 插入员工数据，传入的是一个map(name=员工的名字,salary=员工的薪水)
    int insertEmpMap(Map data);
    // 根据id删除员工信息
    int deleteById(Integer id);

    // 动态SQL查询，自动拼接条件，根据员工姓名和工资查询员工信息
    List<Employee> queryByDynamicSql(@Param("name") String name, @Param("salary") Double salary);
    // 动态SQL更新，根据员工id更新员工的数据，传入的name和salary不为null的才更新
    int updateEmp(Employee employee);
    // 根据两个条件查询，如果姓名不为空用姓名查询，否则薪水不为空用薪水查询，都为空查询全部。
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);
    // 动态SQL 根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);
    // 动态SQL 批量插入
    int insertBatch(@Param("list") List<Employee> employeeList);

}
