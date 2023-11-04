package org.rusty.controller;

import lombok.RequiredArgsConstructor;
import org.rusty.model.rest.CourseDTO;
import org.rusty.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/course/all")
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{courseId}")
    public CourseDTO getCourse(@PathVariable("courseId") UUID id) {
        return courseService.getCourse(id);
    }
}