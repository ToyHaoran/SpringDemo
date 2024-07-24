package com.haoran.test;

import com.haoran.config.JavaConfig;
import com.haoran.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(classes = {JavaConfig.class})
public class SpringIoCTest {

    @Autowired
    private StudentController studentController;

    @Test  // 传统测试方式
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.findAll();
    }

    @Test  // 自动创建容器，测试方式
    public void test2(){
        studentController.findAll();
        studentController.testReadOnly();
    }

    @Test
    public void test3() throws FileNotFoundException {
        studentController.testExceptionRollback();
    }
}
