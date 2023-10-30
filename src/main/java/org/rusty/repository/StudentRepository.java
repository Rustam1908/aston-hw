package org.rusty.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rusty.entity.Student;
import org.rusty.service.SessionFactoryProvider;

import java.util.List;

@Slf4j
public class StudentRepository {

    private final SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    public List<Student> findAll() {
        Transaction transaction = null;
        List<Student> students = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
        return students;
    }

    public void save(Student student) {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
    }
}
