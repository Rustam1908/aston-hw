package org.rusty.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rusty.entity.Course;
import org.rusty.entity.Student;
import org.rusty.service.SessionFactoryProvider;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
public class CourseRepository {

    private final SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    public List<Course> findAll() {

        return Collections.emptyList();
    }

    public Course getById(UUID id) {
        Transaction transaction = null;
        Course course = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            course = session.get(Course.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
        return course;
    }

    public void save(Course course) {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
    }
}
