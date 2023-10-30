package org.rusty.entity.students;

import jakarta.persistence.Column;
import org.rusty.entity.Student;

public class Intern extends Student {

    @Column(name = "promising")
    private boolean promising;
}
