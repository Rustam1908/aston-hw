package org.rusty.service;

import org.rusty.repository.CourseRepository;

public class CourseService {

    private static volatile CourseService instance;

    private final CourseRepository courseRepository = CourseRepository.getInstance();

    private CourseService() {}

    public static CourseService getInstance() {
        if (instance == null) {
            synchronized (CourseService.class) {
                if (instance == null) {
                    instance = new CourseService();
                }
            }
        }
        return instance;
    }

    public String handleGetRequest() {
        StringBuilder sb = new StringBuilder();
        courseRepository.findAll()
                .ifPresent(courses -> courses.forEach(course -> sb
                        .append(course.getTitle())
                        .append(", продолжительность: ")
                        .append(course.getDuration())
                        .append(" месяцев,\n-> студенты: ")
                        .append(course.getStudents())
                        .append(",\n-> учителя: ")
                        .append(course.getTeachers())
                        .append("\n"))
                );
        return sb.toString();
    }
}
