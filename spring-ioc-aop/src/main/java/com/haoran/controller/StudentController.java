package com.haoran.controller;

import com.haoran.pojo.Student;
import com.haoran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
@Transactional  // 添加在类上，所有方法都有事务。可单独添加在方法上，会覆盖类上注解。
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void findAll(){
        List<Student> all = studentService.findAll();
        System.out.println("all = " + all);
    }

    // 一般都加在类上，查询事务需要单独设置只读模式，提升效率。
    @Transactional(readOnly = true)
    public void testReadOnly(){
        // 查询数据库，不修改，没有必要添加事务！
        List<Student> all = studentService.findAll();
        System.out.println("Transactional--all = " + all);
    }

    // timeout = 设置事务超时时间/秒s 默认:-1永不超时。
    @Transactional(timeout = 3)
    public void testTimeout(){
        studentService.updateAgeById(100,1);
        //休眠4秒，等待方法超时!
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentService.updateNameById("test1",1);
    }

    @Transactional(rollbackFor = Exception.class,  // 异常回滚，默认只有运行时异常、Error才回滚
            noRollbackFor = {FileNotFoundException.class,},  // 某些异常，不回滚，但是会中断程序
            isolation = Isolation.READ_COMMITTED)  // 事务隔离级别
    public void testExceptionRollback() throws FileNotFoundException {
        studentService.updateAgeById(99,1);
        // int i = 10/0;
        new FileInputStream("xxxx");
        studentService.updateNameById("test3",1);
    }

    // 事务传播行为，多个事务时间的影响
    // propagation = Propagation.REQUIRED (默认)父方法有事务，我们就加入到父方法的事务！最终是同一个事务！
    // propagation = Propagation.REQUIRES_NEW 不管父方法是否有事务，我都是独立的事务！两个事务或者三个事务！
}
