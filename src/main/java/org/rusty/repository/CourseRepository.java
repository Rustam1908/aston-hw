package org.rusty.repository;

import org.rusty.entity.Course;
import org.rusty.service.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {

    private static volatile CourseRepository instance;

    private final ConnectionProvider connectionProvider = ConnectionProvider.getInstance();

    private CourseRepository() {}

    public static CourseRepository getInstance() {
        if (instance == null) {
            synchronized (CourseRepository.class) {
                if (instance == null) {
                    instance = new CourseRepository();
                }
            }
        }
        return instance;
    }

    public Optional<List<Course>> findAll() {
        List<Course> courses;
        String findAllCoursesSQLQuery =
                "SELECT Course.course_id, title, duration,\n" +
                "STRING_AGG(DISTINCT Student.last_name, ', ') students, \n" +
                "STRING_AGG(DISTINCT Teacher.last_name, ', ') teachers\n" +
                "FROM Student\n" +
                "JOIN CourseStudent ON Student.student_id = CourseStudent.student_id\n" +
                "JOIN Course ON Course.course_id = CourseStudent.course_id\n" +
                "JOIN Teacher ON Course.course_id = Teacher.course_id\n" +
                "GROUP BY Course.course_id ORDER BY Course.course_id;";
        try (Statement statement = connectionProvider.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(findAllCoursesSQLQuery)) {
            courses = new ArrayList<>();
            Course course;
            while (resultSet.next()) {
                course = Course.builder()
                        .courseId(resultSet.getInt("course_id"))
                        .title(resultSet.getString("title"))
                        .duration(resultSet.getInt("duration"))
                        .students(resultSet.getString("students"))
                        .teachers(resultSet.getString("teachers"))
                        .build();
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(courses);
    }
}
