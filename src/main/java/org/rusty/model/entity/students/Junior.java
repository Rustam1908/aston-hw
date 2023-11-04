package org.rusty.model.entity.students;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.rusty.model.entity.Student;
import org.rusty.enums.Achievements;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Junior")
@DiscriminatorValue(value = "JUNIOR")
@Getter
@Setter
public class Junior extends Student {

    @Enumerated(EnumType.STRING)
    @Column(name = "achievements")
    private Achievements achievements;
}
