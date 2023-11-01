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
@Table(name = "Intern")
@DiscriminatorValue(value = "INTERN")
public class Intern extends Student {

    @Column(name = "promising")
    private boolean promising;

    public boolean isPromising() {
        return promising;
    }

    public void setPromising(boolean promising) {
        this.promising = promising;
    }
}
