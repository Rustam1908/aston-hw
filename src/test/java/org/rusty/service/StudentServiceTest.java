package org.rusty.service;

import org.junit.Test;
import org.rusty.entity.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentServiceTest {

    private final StudentService studentService = StudentService.getInstance();

    @Test
    public void handleGetRequest() {
        List<Student> studentList = new ArrayList<>();
        Student student = Student.builder()
                .studentId(1)
                .firstName("Иван")
                .lastName("Иванов")
                .courses("JAVA")
                .build();
        studentList.add(student);

        String s = studentService.buildString(studentList);
        String expectedS = "Иван Иванов, курсы: JAVA\n";

        assertEquals(expectedS, s);
    }
}