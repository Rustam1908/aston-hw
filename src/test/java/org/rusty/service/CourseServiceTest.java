package org.rusty.service;

import org.junit.Test;
import org.rusty.entity.Course;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CourseServiceTest {

    private final CourseService courseService = CourseService.getInstance();

    @Test
    public void buildString() {
        List<Course> courseList = new ArrayList<>();
        Course course = Course.builder()
                .courseId(1)
                .title("Angular")
                .duration(6)
                .students("Белов, Ганиуллин, Ермаков")
                .teachers("Петров, Сидоров")
                .build();
        courseList.add(course);

        String s = courseService.buildString(courseList);
        String expectedS = "Angular, продолжительность: 6 месяцев,\n" +
                "-> студенты: Белов, Ганиуллин, Ермаков\n" +
                "-> учителя: Петров, Сидоров\n";

        assertEquals(expectedS, s);
    }
}