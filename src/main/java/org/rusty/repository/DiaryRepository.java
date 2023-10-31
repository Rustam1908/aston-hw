package org.rusty.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rusty.entity.Diary;
import org.rusty.service.SessionFactoryProvider;

@Slf4j
public class DiaryRepository {

    private final SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    public void save(Diary diary) {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(diary);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
    }

    public Diary getById(int id) {
        Transaction transaction = null;
        Diary diary = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            diary = session.get(Diary.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
        return diary;
    }
}
