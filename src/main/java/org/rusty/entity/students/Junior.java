package org.rusty.entity.students;

import jakarta.persistence.*;
import org.rusty.entity.Student;
import org.rusty.enums.Achievements;

@Entity
@Table(name = "Junior")
@DiscriminatorValue(value = "JUNIOR")
public class Junior extends Student {

    @Enumerated(EnumType.STRING)
    @Column(name = "achievements")
    private Achievements achievements;
}
