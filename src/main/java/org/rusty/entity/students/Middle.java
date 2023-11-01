package org.rusty.entity.students;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.rusty.entity.Student;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Middle")
@DiscriminatorValue(value = "MIDDLE")
@Data
public class Middle extends Student {

    @Column(name = "awards")
    private String awards;
}
