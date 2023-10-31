package org.rusty.service;

import org.rusty.entity.Course;
import org.rusty.repository.CourseRepository;
import org.rusty.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    public String getCourseList() {
        List<Course> courses = courseRepository.findAll();
        return buildString(courses);
    }

    public Course getCourseById(int id) {
        return courseRepository.getById(id);
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
