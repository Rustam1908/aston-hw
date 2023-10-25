package org.rusty.service;

import org.rusty.entity.Teacher;
import org.rusty.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

public class TeacherService {

    private static volatile TeacherService instance;

    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();

    private TeacherService() {}

    public static TeacherService getInstance() {
        if (instance == null) {
            synchronized (TeacherService.class) {
                if (instance == null) {
                    instance = new TeacherService();
                }
            }
        }
        return instance;
    }

    public String handleGetRequest() {
        Optional<List<Teacher>> teachersOpt = teacherRepository.findAll();
        if (teachersOpt.isPresent()) {
            return buildString(teachersOpt.get());
        }
        throw new RuntimeException("Result list is null.");
    }

    public String buildString(List<Teacher> teachers) {
        StringBuilder sb = new StringBuilder();
        teachers.forEach(teacher -> sb
                .append(teacher.getFirstName())
                .append(" ")
                .append(teacher.getLastName())
                .append(", курс: ")
                .append(teacher.getCourse())
                .append("\n"));
        return sb.toString();
    }
}
