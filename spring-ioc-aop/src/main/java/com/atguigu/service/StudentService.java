package com.atguigu.service;

import com.atguigu.pojo.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    void updateAgeById(Integer age, Integer id);

    void updateNameById(String name, Integer id);
}
