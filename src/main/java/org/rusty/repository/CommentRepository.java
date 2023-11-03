package org.rusty.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.rusty.entity.Comment;
import org.rusty.entity.Teacher;
import org.rusty.entity.students.Junior;
import org.rusty.service.SessionFactoryProvider;

import java.util.List;
import java.util.UUID;

@Slf4j
public class CommentRepository {

    private final SessionFactory factory = SessionFactoryProvider.getSessionFactory();

    public void init() {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

//            Teacher t = session.get(Teacher.class, UUID.fromString("86b1d25e-a686-4596-a6ed-cbaf531ff90f"));
            Teacher t = session.get(Teacher.class, UUID.fromString("a105eb43-5b1e-4207-b2ec-ebaf13103565"));

            for (int i = 0; i < 10; i++) {
                Comment comment = new Comment();
                comment.setTeacher(t);
                session.persist(comment);
            }

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
    }

    public void pull() {
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            List<Comment> resultList1 =
                    session.createQuery("SELECT c FROM Comment c JOIN c.teacher t", Comment.class).getResultList();

            System.out.println("-----------------------");

            List<Comment> resultList2 =
                    session.createQuery("SELECT c FROM Comment c JOIN FETCH c.teacher t", Comment.class).getResultList();


            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
    }
}
