package org.rusty.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.rusty.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentRepositoryTest {

    @InjectMocks
    private StudentRepository studentRepository;

    @Mock
    private ResultSet resultSet;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void process_resultSet_test() throws SQLException {
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("student_id")).thenReturn(1);
        when(resultSet.getString("first_name")).thenReturn("Иван");
        when(resultSet.getString("last_name")).thenReturn("Иванов");
        when(resultSet.getString("courses")).thenReturn("JAVA");

        List<Student> students = studentRepository.processResultSet(resultSet);

        Student testStudent = students.get(0);
        assertEquals(1, students.size());
        assertEquals(1, testStudent.getStudentId());
        assertEquals("Иван", testStudent.getFirstName());
        assertEquals("Иванов", testStudent.getLastName());
        assertEquals("JAVA", testStudent.getCourses());
    }
}