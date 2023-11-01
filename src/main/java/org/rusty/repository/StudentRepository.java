package org.rusty.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.rusty.entity.Course;
import org.rusty.entity.Diary;
import org.rusty.entity.Student;
import org.rusty.service.SessionFactoryProvider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
public class StudentRepository {

    private final SessionFactory factory = SessionFactoryProvider.getSessionFactory();
    private final CourseRepository courseRepository = new CourseRepository();

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

    public void save(Student student, Set<UUID> coursesIds) {
        Transaction transaction = null;
        Set<Course> courses = new HashSet<>();
        Diary diary = new Diary();

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();

            for (UUID courseId : coursesIds) {
                courses.add(session.get(Course.class, courseId));
            }
            student.setCourses(courses);

            session.persist(diary);
            student.setDiary(diary);

            session.persist(student);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            log.error(e.getMessage());
        }
    }
}
