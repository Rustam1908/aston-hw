package org.rusty.model.rest;

import lombok.Data;
import org.rusty.model.entity.Teacher;

import java.util.List;
import java.util.UUID;

@Data
public class CourseDTO {

    private UUID courseId;
    private String title;
    private int duration;
    private List<Teacher> teachers;
}
