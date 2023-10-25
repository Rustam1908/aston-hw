package org.rusty.repository;

import org.rusty.entity.Student;
import org.rusty.service.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {

    private static volatile StudentRepository instance;

    private final ConnectionProvider connectionProvider = ConnectionProvider.getInstance();

    private StudentRepository() {}

    public static StudentRepository getInstance() {
        if (instance == null) {
            synchronized (StudentRepository.class) {
                if (instance == null) {
                    instance = new StudentRepository();
                }
            }
        }
        return instance;
    }

    public Optional<List<Student>> findAll() {
        List<Student> students;
        String findAllStudentsSQLQuery =
                "SELECT Student.student_id, first_name, last_name, STRING_AGG(title, ', ') courses FROM Student\n" +
                "JOIN CourseStudent ON Student.student_id = CourseStudent.student_id\n" +
                "JOIN Course ON Course.course_id = CourseStudent.course_id\n" +
                "GROUP BY Student.student_id ORDER BY Student.student_id;";
        try (Statement statement = connectionProvider.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(findAllStudentsSQLQuery)) {
            students = processResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(students);
    }

    private List<Student> processResultSet(ResultSet resultSet) throws SQLException {
        List<Student> students = new ArrayList<>();
        Student student;
        while (resultSet.next()) {
            student = Student.builder()
                    .studentId(resultSet.getInt("student_id"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .courses(resultSet.getString("courses"))
                    .build();
            students.add(student);
        }
        return students;
    }
}
