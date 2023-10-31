package org.rusty.entity.students;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.rusty.entity.Student;

@Entity
@Table(name = "Intern")
@DiscriminatorValue(value = "INTERN")
public class Intern extends Student {

    @Column(name = "promising")
    private boolean promising;
}
