package orm.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import orm.task_6.model.Animal;
import orm.task_6.model.Man;
import orm.task_6.model.task8.concrete.Person3;
import orm.task_6.model.task8.concrete.Student3;
import orm.task_6.model.task8.concrete.Teacher3;
import orm.task_6.model.task8.hierarchy.Person;
import orm.task_6.model.task8.hierarchy.Student;
import orm.task_6.model.task8.hierarchy.Teacher;
import orm.task_6.model.task8.subclass.Person2;
import orm.task_6.model.task8.subclass.Student2;
import orm.task_6.model.task8.subclass.Teacher2;

public class HibernateUtil {

    private static HibernateUtil INSTANCE;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Man.class)
                    .addAnnotatedClass(Animal.class)
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(Person2.class)
                    .addAnnotatedClass(Student2.class)
                    .addAnnotatedClass(Teacher2.class)
                    .addAnnotatedClass(Person3.class)
                    .addAnnotatedClass(Student3.class)
                    .addAnnotatedClass(Teacher3.class)
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
