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
        String findAllStudentsSQLQuery = "SELECT * FROM Student";
        try (Statement statement = connectionProvider.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(findAllStudentsSQLQuery)) {
            students = new ArrayList<>();
            Student student;
            while (resultSet.next()) {
                student = Student.builder()
                        .studentId(resultSet.getInt("student_id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .build();
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(students);
    }
}
