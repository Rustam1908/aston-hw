package org.rusty.entity;

import lombok.Data;

@Data
public class Teacher {

    private int teacherId;
    private String firstName;
    private String lastName;
    private Course course;
}
