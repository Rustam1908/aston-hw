package org.rusty.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.service.ServiceRegistry;
import org.rusty.entity.*;
import org.rusty.entity.students.Intern;
import org.rusty.entity.students.Junior;
import org.rusty.entity.students.Middle;

import java.util.Properties;

public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = getConfiguration();

            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(Diary.class);
            configuration.addAnnotatedClass(Comment.class);

            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Intern.class);
            configuration.addAnnotatedClass(Junior.class);
            configuration.addAnnotatedClass(Middle.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/aston_hw_servlet");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "postgres");
        properties.put("hibernate.connection.pool_size", "1");

//        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        WARN: HHH90000025: PostgreSQLDialect does not need to be specified explicitly using 'hibernate.dialect'
        properties.put("hibernate.current_session_context_class", "thread");
        properties.put("hibernate.show_sql", "true");

        configuration.setProperties(properties);

        return configuration;
    }
}