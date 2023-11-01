package org.rusty.entity.students;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.rusty.entity.Student;
import org.rusty.enums.Achievements;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Junior")
@DiscriminatorValue(value = "JUNIOR")
@Data
public class Junior extends Student {

    @Enumerated(EnumType.STRING)
    @Column(name = "achievements")
    private Achievements achievements;
}
