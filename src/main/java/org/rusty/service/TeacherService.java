package org.rusty.service;

import org.rusty.repository.TeacherRepository;

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
        StringBuilder sb = new StringBuilder();
        teacherRepository.findAll()
                .ifPresent(teachers -> teachers.forEach(teacher -> sb
                        .append(teacher.getFirstName())
                        .append(" ")
                        .append(teacher.getLastName())
                        .append(", курс: ")
                        .append(teacher.getCourse())
                        .append("\n"))
                );
        return sb.toString();
    }
}
