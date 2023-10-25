package org.rusty.repository;

import org.rusty.entity.Student;
import org.rusty.service.ConnectionProvider;

import java.util.Collections;
import java.util.List;

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

    public List<Student> findAll() {

        return Collections.emptyList();
    }
}
