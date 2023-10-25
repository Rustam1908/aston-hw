package org.rusty.service;

import org.rusty.entity.Student;
import org.rusty.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private static volatile StudentService instance;

    private final StudentRepository studentRepository = StudentRepository.getInstance();

    private StudentService() {}

    public static StudentService getInstance() {
        if (instance == null) {
            synchronized (StudentService.class) {
                if (instance == null) {
                    instance = new StudentService();
                }
            }
        }
        return instance;
    }

    public String handleGetRequest() {
        Optional<List<Student>> studentsOpt = studentRepository.findAll();
        if (studentsOpt.isPresent()) {
            return buildString(studentsOpt.get());
        }
        throw new RuntimeException("Result list is null.");
    }

    public String buildString(List<Student> students) {
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
