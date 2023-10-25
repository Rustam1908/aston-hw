package org.rusty.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {

    private int courseId;
    private String title;
    private int duration;
    private String students;
    private String teachers;
}
