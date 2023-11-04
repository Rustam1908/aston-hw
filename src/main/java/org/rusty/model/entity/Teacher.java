package org.rusty.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Teacher")
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "teacher_id", nullable = false, unique = true)
    private UUID teacherId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;
}