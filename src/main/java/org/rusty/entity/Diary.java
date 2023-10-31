package org.rusty.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Diary")
@Data
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
