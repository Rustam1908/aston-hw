package org.rusty.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.rusty.entity.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TeacherRepositoryTest {

    @InjectMocks
    private TeacherRepository teacherRepository;

    @Mock
    private ResultSet resultSet;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void process_resultSet_test() throws SQLException {
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("teacher_id")).thenReturn(1);
        when(resultSet.getString("first_name")).thenReturn("Иван");
        when(resultSet.getString("last_name")).thenReturn("Иванов");
        when(resultSet.getString("title")).thenReturn("Angular");

        List<Teacher> teachers = teacherRepository.processResultSet(resultSet);

        Teacher testTeacher = teachers.get(0);
        assertEquals(1, teachers.size());
        assertEquals(1, testTeacher.getTeacherId());
        assertEquals("Иван", testTeacher.getFirstName());
        assertEquals("Иванов", testTeacher.getLastName());
        assertEquals("Angular", testTeacher.getCourse());
    }
}