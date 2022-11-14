package orm.task_6.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.task_6.model.Man;
import orm.util.HibernateUtil;

import java.util.List;

public class ManDaoImpl implements ManDao {

    private final SessionFactory sessionFactory;

    public ManDaoImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void create(Man man) {
        Transaction tx = null;
        try (Session sess = sessionFactory.openSession()) {
            tx = sess.beginTransaction();
            sess.save(man);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Man> readAll() {
        Session session = sessionFactory.openSession();
        List<Man> mans = session.createQuery("from Man", Man.class).list();
        session.close();
        return mans;
    }

    @Override
    public List readAllId() {
        Session session = sessionFactory.openSession();
        List ids = session.createQuery("SELECT id FROM Man").list();
        session.close();
        return ids;
    }

}
