package org.rusty.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Diary")
@Getter
@Setter
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diary_id", nullable = false, unique = true)
    private UUID diaryId;

    @Column(name = "marks")
    private String marks;

    @OneToOne(mappedBy = "diary")
    private Student student;
}
