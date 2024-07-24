package com.haoran.test;

import com.haoran.mapper.EmployeeMapper;
import com.haoran.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    private SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //3.根据sqlSessionFactory创建sqlSession (每次业务创建一个，用完就释放)
        //openSession(true)自动开启事务，自动提交事务! 不需要sqlSession.commit();
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void test_01() throws IOException {
        //4.获取接口的代理对象 (代理技术) 调用代理对象的方法，就会查找mapper接口的方法
        //jdk动态代理技术生成的mapper代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("小明");
        employee.setEmpSalary(1000.0);
        // mapper.insertEmp(employee);
        System.out.println("employee主键值 = " + employee.getEmpId());
        System.out.println("employee1 = " + mapper.queryById(1));
        System.out.println("employee2 = " + mapper.queryByNameAndSalary("小明", 1000.0));
        System.out.println("employee3 = " + mapper.queryBySalary(1000.0));
        System.out.println("employee4 = " + mapper.queryEmpNameAndMaxSalary());
    }

    @AfterEach
    public void after() {
        //5.提交事务(非DQL)和释放资源
        // sqlSession.commit();
        sqlSession.close();
    }
}
