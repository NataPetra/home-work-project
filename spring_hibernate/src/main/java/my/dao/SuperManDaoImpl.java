package my.dao;

import my.entity.SuperMan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SuperManDaoImpl implements SuperManDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSuperMan(SuperMan superMan) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(superMan);
    }

    @Override
    public SuperMan getSuperMan(Integer id) {
        return sessionFactory.getCurrentSession()
                .get(SuperMan.class, id);
    }

    @Override
    public void deleteSuperMan(Integer id) {
        sessionFactory.getCurrentSession()
                .delete(getSuperMan(id));
    }
}
