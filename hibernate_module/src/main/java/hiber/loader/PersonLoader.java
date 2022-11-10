package hiber.loader;

import hiber.MysqlSessionFactory;
import hiber.dao.PersonDao;
import hiber.dao.PersonDaoImpl;
import hiber.model.Person;
import hiber.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class PersonLoader {
    public static void main(String[] args) {
        Person person1 = new Person(null, 30, "John", "Smith");
        Person person2 = new Person(null, 25, "Jane", "Smith");
        Person person3 = new Person(null, 40, "Kat", "Smith");
        EntityManager em = HibernateUtil.getInstance();
        em.getTransaction().begin();
        em.persist(person1);
        em.persist(person2);
        em.getTransaction().commit();
        HibernateUtil.close();
        System.out.println(loadingWithGet(1));
        System.out.println(loadingWithLoad(2));
        System.out.println(loadingWithGet(3));
        System.out.println(loadingWithLoad(4));
        PersonDao personDao = new PersonDaoImpl();
        personDao.create(person3);
        personDao.delete(person3);
    }

    public static boolean loadingWithGet(Integer id) {
        Session session = MysqlSessionFactory.getInstance().openSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.close();
        return person != null;
    }

    public static boolean loadingWithLoad(Integer id) {
        Session session = MysqlSessionFactory.getInstance().openSession();
        session.beginTransaction();
        Person person = session.load(Person.class, id);
//        Person personTest = (Person) person;
//        System.out.println(personTest.toString());
        session.close();
        return person != null;
    }
}
