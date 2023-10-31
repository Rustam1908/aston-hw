package org.rusty.service;

import org.rusty.entity.Diary;
import org.rusty.entity.Student;
import org.rusty.repository.DiaryRepository;
import org.rusty.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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

//        Set<Course> courses = Set.of(
//            courseService.getCourseById(1),
//            courseService.getCourseById(2)
//        );

        Diary diary = new Diary();
//        diary.setDiaryId(UUID.randomUUID());
        diaryRepository.save(diary);

//        Student student = new Intern();
//        student.setFirstName("Ivan");
//        student.setLastName("Ivanov");
//        student.setCourses(courses);
//        student.setMarkDiary();
//        studentRepository.save(student);




        return "Студенты добавлены!";
    }
}
