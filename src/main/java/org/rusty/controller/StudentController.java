package org.rusty.controller;

import lombok.RequiredArgsConstructor;
import org.rusty.model.rest.StudentDTO;
import org.rusty.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student/all")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{studentId}")
    public StudentDTO getStudent(@PathVariable("studentId") Integer id) {
        return studentService.getStudent(id);
    }
}
