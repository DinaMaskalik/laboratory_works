package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionUtil() {
    }

    public static SessionFactory getSessionFactory() {

        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

        sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();

        return sessionFactory;
    }
}
