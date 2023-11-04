package org.rusty.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.util.Set;

@Entity
@Table(name = "Student")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "student_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    @GenericGenerator(
        name = "student_seq_gen",
        type = SequenceStyleGenerator.class,
        parameters = {
            @Parameter(name = "sequence_name", value = "student_seq"),
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "5")
        }
    )
    @Column(name = "student_id", nullable = false, unique = true)
    private int studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Student_Course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private Set<Course> courses;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diary_id", referencedColumnName = "diary_id")
    private Diary diary;
}