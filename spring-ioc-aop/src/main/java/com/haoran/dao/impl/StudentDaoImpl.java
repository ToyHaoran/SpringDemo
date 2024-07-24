package com.haoran.dao.impl;

import com.haoran.dao.StudentDao;
import com.haoran.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl  implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> queryAll() {
        String sql = "select id , name , age , gender , class as classes from students ;";
        // query可以返回集合! BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }

    @Override
    public void updateNameById(String name,Integer id){
        String sql = "update students set name = ? where id = ? ;";
        jdbcTemplate.update(sql, name, id);
    }

    @Override
    public void updateAgeById(Integer age,Integer id){
        String sql = "update students set age = ? where id = ? ;";
        jdbcTemplate.update(sql,age,id);
    }
}
