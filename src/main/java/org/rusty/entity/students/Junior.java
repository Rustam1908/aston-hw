package org.rusty.entity.students;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.rusty.entity.Student;
import org.rusty.enums.Achievements;

public class Junior extends Student {

    @Enumerated(EnumType.STRING)
    @Column(name = "achievements")
    private Achievements achievements;
}
