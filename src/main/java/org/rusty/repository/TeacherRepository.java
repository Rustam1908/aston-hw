package org.rusty.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rusty.entity.Teacher;
import org.rusty.service.SessionFactoryProvider;

import java.util.Collections;
import java.util.List;

@Slf4j
public class TeacherRepository {

    private final SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    public List<Teacher> findAll() {

        return Collections.emptyList();
    }

    public void init() {
        Transaction transaction = null;

        Teacher teacher01 = new Teacher();
        teacher01.setFirstName("Vova");

        Teacher teacher02 = new Teacher();
        teacher02.setFirstName("Ivan");

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(teacher01);
            session.persist(teacher02);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
    }
}
