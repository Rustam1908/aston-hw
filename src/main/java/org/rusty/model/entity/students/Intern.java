package org.rusty.model.entity.students;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.rusty.model.entity.Student;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Intern")
@DiscriminatorValue(value = "INTERN")
@Getter
@Setter
public class Intern extends Student {

    @Column(name = "promising")
    private boolean promising;
}
