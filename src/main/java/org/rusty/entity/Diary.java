package org.rusty.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Diary")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "diary_id", nullable = false, unique = true)
    private UUID diaryId;

    @Column(name = "marks")
    private String marks;

    @OneToOne(mappedBy = "diary")
    private Student student;

    public UUID getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(UUID diaryId) {
        this.diaryId = diaryId;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
