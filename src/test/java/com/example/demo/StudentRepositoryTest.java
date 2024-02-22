package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private StudentRepository myService;

    @Test
    public void testInsertSuccess() {
        Student student = new Student(1, "John Doe", 25);

        myService.insert(student);

        String expectedQuery = "insert into student";
        verify(jdbcTemplate).update(
                argThat((ArgumentMatcher<String>) query -> query.contains(expectedQuery)),
                eq(student.getId()),
                eq(student.getName()),
                eq(student.getAge())
        );
    }
}
