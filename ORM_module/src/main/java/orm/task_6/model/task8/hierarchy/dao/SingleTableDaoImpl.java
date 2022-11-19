package orm.task_6.model.task8.hierarchy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.task_6.model.task8.hierarchy.Person;
import orm.util.HibernateUtil;

import java.util.List;

public class SingleTableDaoImpl implements SingleTableDao{

    private final SessionFactory sessionFactory;

    public SingleTableDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(Person person) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
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
    public List readAll() {
        Session session = sessionFactory.openSession();
        List persons = session.createQuery("from Person", Person.class).list();
        session.close();
        return persons;
    }
}
