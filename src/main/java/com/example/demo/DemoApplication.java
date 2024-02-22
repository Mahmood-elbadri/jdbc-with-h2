package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(studentRepository.findAllStudents());
        for (int i = 1; i <= 3; i++) {
            System.out.println(studentRepository.findById(i));
        }
        studentRepository.deleteById(2);
        System.out.println(studentRepository.findAllStudents());
        System.out.println(studentRepository.update(new Student(1,"zizi",26)));
        System.out.println(studentRepository.findAllStudents());
        studentRepository.insert(new Student(4,"Cristiano Ronaldo",18));
        System.out.println(studentRepository.findAllStudents());


    }
}
