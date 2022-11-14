package hiber.dao;

import hiber.MysqlSessionFactory;
import hiber.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDaoImpl implements PersonDao{

    private final SessionFactory sessionFactory;

    public PersonDaoImpl() {
        this.sessionFactory = MysqlSessionFactory.getInstance();
    }

    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Person person) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()){
            tx = sess.beginTransaction();
            sess.save(person);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Person getPerson(Integer id) {
        Session session = MysqlSessionFactory.getInstance().openSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    @Override
    public List<Person> readAll() {
        Session session = sessionFactory.openSession();
        List<Person> persons = session.createQuery("from Person", Person.class).list();
        session.close();
        return persons;
    }

    @Override
    public void update(Person person) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()){
            tx = sess.beginTransaction();
            sess.update(person);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void delete(Person person) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void delete(long id) {
        Person person = sessionFactory.openSession()
                .load(Person.class, id);
        delete(person);
    }
}
