package org.rusty.controller;

import lombok.RequiredArgsConstructor;
import org.rusty.model.rest.TeacherDTO;
import org.rusty.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teacher/all")
    public List<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teacher/{teacherId}")
    public TeacherDTO getTeacher(@PathVariable("teacherId") UUID id) {
        return teacherService.getTeacher(id);
    }
}
