package com.haoran.service.impl;

import com.haoran.dao.StudentDao;
import com.haoran.pojo.Student;
import com.haoran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
