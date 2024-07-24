package com.atguigu.service.impl;

import com.atguigu.dao.StudentDao;
import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.queryAll();
    }

    @Override
    public void updateAgeById(Integer age, Integer id) {
        studentDao.updateAgeById(age,id);
    }

    @Override
    public void updateNameById(String name, Integer id) {
        studentDao.updateNameById(name,id);
    }
}
