package org.rusty.entity.students;

import jakarta.persistence.Column;
import org.rusty.entity.Student;

public class Middle extends Student {

    @Column(name = "awards")
    private String awards;
}
