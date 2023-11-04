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
@DiscriminatorValue(value = "MIDDLE")
@Getter
@Setter
public class Middle extends Student {

    @Column(name = "awards")
    private String awards;
}
