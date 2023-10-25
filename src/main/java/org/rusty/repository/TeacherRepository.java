package org.rusty.repository;

import org.rusty.entity.Course;
import org.rusty.entity.Teacher;
import org.rusty.service.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherRepository {

    private final ConnectionProvider connectionProvider = ConnectionProvider.getInstance();

    public Optional<List<Teacher>> findAll() {
        List<Teacher> teachers;
        String findAllTeachersSQLQuery =
                "SELECT Teacher.teacher_id, first_name, last_name, title\n" +
                        "FROM Teacher\n" +
                        "JOIN Course ON Course.course_id = Teacher.course_id\n" +
                        "ORDER BY Teacher.teacher_id;";
        try (Statement statement = connectionProvider.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(findAllTeachersSQLQuery)) {
            teachers = processResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(teachers);
    }

    public List<Teacher> processResultSet(ResultSet resultSet) throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher;
        while (resultSet.next()) {
            teacher = Teacher.builder()
                    .teacherId(resultSet.getInt("teacher_id"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .course(resultSet.getString("title"))
                    .build();
            teachers.add(teacher);
        }
        return teachers;
    }
}
