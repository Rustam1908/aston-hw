package org.rusty.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.rusty.entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CourseRepositoryTest {

    @InjectMocks
    private CourseRepository courseRepository;

    @Mock
    private ResultSet resultSet;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void process_resultSet_test() throws SQLException {
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("course_id")).thenReturn(1);
        when(resultSet.getString("title")).thenReturn("JAVA");
        when(resultSet.getInt("duration")).thenReturn(6);
        when(resultSet.getString("students")).thenReturn("Иванов, Петров");
        when(resultSet.getString("teachers")).thenReturn("Сидоров, Соколов");

        List<Course> courses = courseRepository.processResultSet(resultSet);

        Course testCourse = courses.get(0);
        assertEquals(1, courses.size());
        assertEquals(1, testCourse.getCourseId());
        assertEquals("JAVA", testCourse.getTitle());
        assertEquals(6, testCourse.getDuration());
        assertEquals("Иванов, Петров", testCourse.getStudents());
        assertEquals("Сидоров, Соколов", testCourse.getTeachers());
    }
}