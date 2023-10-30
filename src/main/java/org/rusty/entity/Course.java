package org.rusty.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Course")
@Data
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int courseId;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private int duration;

    @ManyToMany
    private Set<Student> students;

    @OneToMany
    private List<Teacher> teachers;
}