package org.rusty.service;

import org.rusty.entity.Student;
import org.rusty.entity.students.Junior;
import org.rusty.entity.students.Middle;
import org.rusty.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public String getJuniorList() {
        List<Junior> juniors = studentRepository.findAllJuniors();
        return buildString(juniors);
    }

    private String buildString(List<? extends Student> students) {
        StringBuilder sb = new StringBuilder();
        students.forEach(student -> sb
                .append(student.getFirstName())
                .append(" ")
                .append(student.getLastName())
                .append(", курсы: ")
                .append(student.getCourses()) // LIE because transactions have to be in this layer
                .append("\n"));
        return sb.toString();
    }

    public String saveNewStudent(HttpServletRequest request) {

//        Set<UUID> courses = Set.of(
//            UUID.fromString("d6fde834-b924-4b7d-84da-e20fc1b5bd70"),
//            UUID.fromString("ac556d39-cced-46ab-8ac0-896acb1c7fa1")
//        );
//
//        Intern intern = new Intern();
//        intern.setFirstName("Ivan");
//        intern.setLastName("Ivanov");
//        intern.setPromising(true);

//        Set<UUID> courses = Set.of(
//            UUID.fromString("34ba28f8-5dac-4a01-b9c0-168d3093bea2"),
//            UUID.fromString("ff36a4a3-6559-4754-ad54-9c910af11d75")
//        );

//        Junior junior = new Junior();
//        junior.setFirstName("Sergey");
//        junior.setLastName("Sergeev");
//        junior.setAchievements(Achievements.AVERAGE);

        Set<UUID> courses = Set.of(
                UUID.fromString("d6fde834-b924-4b7d-84da-e20fc1b5bd70"),
                UUID.fromString("ff36a4a3-6559-4754-ad54-9c910af11d75")
        );

        Middle middle = new Middle();
        middle.setFirstName("Vova");
        middle.setLastName("Vladimirov");
        middle.setAwards("Fullstack Championship Winner");

        studentRepository.save(middle, courses);

        return "Студенты добавлены!";
    }
}
