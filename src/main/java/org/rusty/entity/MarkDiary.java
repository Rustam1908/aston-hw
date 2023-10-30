package org.rusty.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MarkDiary")
@Data
public class MarkDiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "diary_id", nullable = false, unique = true)
    private int diaryId;

    @Column(name = "first_name")
    private String marks;

    @OneToOne(mappedBy = "markDiary")
    private Student student;
}
