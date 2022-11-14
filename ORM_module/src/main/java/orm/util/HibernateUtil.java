package orm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import orm.task_6.model.Animal;
import orm.task_6.model.Man;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static HibernateUtil INSTANCE;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Man.class)
                    .addAnnotatedClass(Animal.class)
                    .configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

//    public Session getSession() {
//        return sessionFactory.openSession();
//    }

    public static SessionFactory getSessionFactory() {
        if (INSTANCE == null) {
            INSTANCE = new HibernateUtil();
        }
        return sessionFactory;
    }

}
