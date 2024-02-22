package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> findAllStudents(){
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<>(Student.class));
    }
    public Student findById(int id){
        return  jdbcTemplate.queryForObject("select * from student where id=?",
                new BeanPropertyRowMapper<>(Student.class),id);
    }
    public void deleteById(int id){
        jdbcTemplate.update("delete \n" +
                "from student\n" +
                "where id = ?\n",id);
    }
    String updateQuery = "UPDATE student\n" +
            "SET name = ?\n" +
            ",age = ?\n" +
            "WHERE id = ?;";
    public int update(Student student){
        return jdbcTemplate.update(updateQuery,student.getName(), student.getAge(), student.getId());
    }
    String insertQuery = "insert into student (id, name, age)\n" +
            "values (?, ?, ?)";
    public void insert(Student student){
        jdbcTemplate.update(insertQuery,student.getId(),student.getName(),student.getAge());
    }
}
