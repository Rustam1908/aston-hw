package org.rusty.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id", nullable = false, unique = true)
    private UUID courseId;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Teacher> teachers;
}