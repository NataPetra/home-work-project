package orm.task_6.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.task_6.model.Animal;
import orm.util.HibernateUtil;

import java.util.List;

public class AnimalDaoImpl implements AnimalDao {

    private final SessionFactory sessionFactory;

    public AnimalDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(Animal animal) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.save(animal);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Animal> readAll() {
        Session session = sessionFactory.openSession();
        List<Animal> animals = session.createQuery("from Animal", Animal.class).list();
        session.close();
        return animals;
    }

    @Override
    public List readAllId() {
        Session session = sessionFactory.openSession();
        List ids = session.createQuery("SELECT id FROM Animal").list();
        session.close();
        return ids;
    }
}
