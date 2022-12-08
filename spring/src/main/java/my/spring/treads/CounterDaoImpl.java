package my.spring.treads;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CounterDaoImpl implements CounterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Counter counter) {
        sessionFactory.getCurrentSession()
                .save(counter);
    }

    @Override
    public void update() {
        Session currentSession = sessionFactory.getCurrentSession();
        Counter counter = currentSession
                .get(Counter.class, 1, LockMode.PESSIMISTIC_WRITE);
        counter.setCount(counter.getCount()+1);
        currentSession.update(counter);
    }

}
