package org.rusty.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private List<Course> courses;
}
