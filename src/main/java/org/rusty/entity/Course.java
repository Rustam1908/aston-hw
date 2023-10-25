package org.rusty.entity;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    private int courseId;
    private String title;
    private int duration;
    private List<Student> students;
    private List<Teacher> teachers;
}
