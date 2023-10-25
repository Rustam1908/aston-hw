package org.rusty.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private String courses;
}
