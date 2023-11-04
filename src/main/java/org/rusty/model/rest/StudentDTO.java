package org.rusty.model.rest;

import lombok.Data;
import org.rusty.model.entity.Course;

import java.util.Set;

@Data
public class StudentDTO {

    private String firstName;
    private String lastName;
    private Set<Course> courses;
}
