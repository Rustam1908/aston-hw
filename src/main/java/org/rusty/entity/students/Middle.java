package org.rusty.entity.students;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.rusty.entity.Student;

@Entity
@Table(name = "Middle")
@DiscriminatorValue(value = "MIDDLE")
public class Middle extends Student {

    @Column(name = "awards")
    private String awards;
}
