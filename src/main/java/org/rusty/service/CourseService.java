package org.rusty.service;

import org.rusty.entity.Course;
import org.rusty.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<List<Course>> coursesOpt = courseRepository.findAll();
        if (coursesOpt.isPresent()) {
            return buildString(coursesOpt.get());
        }
        throw new RuntimeException("Result list is null.");
    }

    public String buildString(List<Course> courses) {
        StringBuilder sb = new StringBuilder();
        courses.forEach(course -> sb
                .append(course.getTitle())
                .append(", продолжительность: ")
                .append(course.getDuration())
                .append(" месяцев,\n-> студенты: ")
                .append(course.getStudents())
                .append("\n-> учителя: ")
                .append(course.getTeachers())
                .append("\n"));
        return sb.toString();
    }
}
