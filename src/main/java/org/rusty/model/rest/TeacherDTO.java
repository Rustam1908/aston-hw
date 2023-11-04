package org.rusty.model.rest;

import lombok.Data;
import org.rusty.model.entity.Course;

import java.util.UUID;

@Data
public class TeacherDTO {

    private UUID teacherId;
    private String firstName;
    private String lastName;
    private Course course;
}
