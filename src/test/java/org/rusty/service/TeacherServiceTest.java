package org.rusty.service;

import org.junit.Test;
import org.rusty.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeacherServiceTest {

    private final TeacherService teacherService = TeacherService.getInstance();

    @Test
    public void buildString() {
        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = Teacher.builder()
                .teacherId(1)
                .firstName("Иван")
                .lastName("Иванов")
                .course("JAVA")
                .build();
        teacherList.add(teacher);

        String s = teacherService.buildString(teacherList);
        String expectedS = "Иван Иванов, курс: JAVA\n";

        assertEquals(expectedS, s);
    }
}