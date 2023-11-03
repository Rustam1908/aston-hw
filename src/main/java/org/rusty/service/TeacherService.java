package org.rusty.service;

import org.rusty.entity.Teacher;
import org.rusty.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

public class TeacherService {

    private final TeacherRepository teacherRepository = new TeacherRepository();

    public String getTeacherList() {
        List<Teacher> teachers = teacherRepository.findAll();
        return buildString(teachers);
    }

    public void init() {
        teacherRepository.init();
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
