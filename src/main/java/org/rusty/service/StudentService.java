package org.rusty.service;

import org.rusty.repository.StudentRepository;

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
        StringBuilder sb = new StringBuilder();
        studentRepository.findAll()
                .ifPresent(students -> students.forEach(student -> sb
                        .append(student.getFirstName())
                        .append(" ")
                        .append(student.getLastName())
                        .append("\n"))
                );
        return sb.toString();
    }
}
