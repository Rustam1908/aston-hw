package org.rusty.service;

import org.rusty.entity.Student;
import org.rusty.entity.students.Intern;
import org.rusty.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

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
        Student student = new Intern();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        studentRepository.save(student);
        return "Студент добавлен!";
    }
}
