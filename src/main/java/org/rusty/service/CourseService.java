package org.rusty.service;

import org.rusty.entity.Course;
import org.rusty.repository.CourseRepository;
import org.rusty.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    public void init() {
        if (courseRepository.findAll().isEmpty()) {
            Course course01 = new Course();
            course01.setTitle("JAVA");
            course01.setDuration(6);
            courseRepository.save(course01);
            Course course02 = new Course();
            course02.setTitle("Python");
            course02.setDuration(6);
            courseRepository.save(course02);
            Course course03 = new Course();
            course03.setTitle("JavaScript");
            course03.setDuration(4);
            courseRepository.save(course03);
            Course course04 = new Course();
            course04.setTitle("Angular");
            course04.setDuration(4);
            courseRepository.save(course04);
        }
    }

    public String getCourseList() {
        List<Course> courses = courseRepository.findAll();
        return buildString(courses);
    }

    public Course getCourseById(UUID id) {
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
