package org.rusty.service;

import org.rusty.entity.Student;
import org.rusty.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public String getStudentList() {
        List<Student> students = studentRepository.findAll();
        return buildString(students);
    }

    private String buildString(List<Student> students) {
        StringBuilder sb = new StringBuilder();
        students.forEach(student -> sb
                .append(student.getFirstName())
                .append(" ")
                .append(student.getLastName())
                .append(", курсы: ")
                .append(student.getCourses())
                .append("\n"));
        return sb.toString();
    }
}
