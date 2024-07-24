package com.haoran.dao;

import com.haoran.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> queryAll();

    void updateNameById(String name, Integer id);

    void updateAgeById(Integer age, Integer id);
}
