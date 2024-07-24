package com.haoran.service;

import com.haoran.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> findAll();

    void updateAgeById(Integer age, Integer id);

    void updateNameById(String name, Integer id);
}
