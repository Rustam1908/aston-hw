package org.rusty.repository;

import org.rusty.entity.Course;
import org.rusty.service.ConnectionProvider;

import java.util.Collections;
import java.util.List;

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

    public List<Course> findAll() {

        return Collections.emptyList();
    }
}
