package org.rusty.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Course")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id", nullable = false, unique = true)
    private UUID courseId;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    @OneToMany(mappedBy = "course")
    private List<Teacher> teachers;
}