package org.rusty.service;

import org.rusty.entity.Course;
import org.rusty.entity.Diary;
import org.rusty.entity.Student;
import org.rusty.entity.students.Intern;
import org.rusty.repository.DiaryRepository;
import org.rusty.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();
    private final DiaryRepository diaryRepository = new DiaryRepository();
    private final CourseService courseService = new CourseService();

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

    public String saveNewStudent(HttpServletRequest request) {
        // todo parse request

        Set<Course> courses = Set.of(
            courseService.getCourseById(UUID.fromString("d6fde834-b924-4b7d-84da-e20fc1b5bd70")),
            courseService.getCourseById(UUID.fromString("ac556d39-cced-46ab-8ac0-896acb1c7fa1"))
        );

        Diary diary = new Diary();
        diaryRepository.save(diary);

        Intern intern = new Intern();
        intern.setFirstName("Ivan");
        intern.setLastName("Ivanov");
        intern.setCourses(courses);
        intern.setDiary(diary);
        intern.setPromising(true);
        studentRepository.save(intern);

        return "Студенты добавлены!";
    }
}
