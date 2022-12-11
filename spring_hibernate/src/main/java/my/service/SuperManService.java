package my.service;

import my.dao.SuperManDao;
import my.entity.SuperMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuperManService {

    @Autowired
    private SuperManDao superManDao;

    @Transactional
    public void newSuperMan(SuperMan superMan){
        superManDao.addSuperMan(superMan);
    }

    @Transactional
    public SuperMan getSuperMan(Integer id){
        return superManDao.getSuperMan(id);
    }

    @Transactional
    public void destroySuperMan(Integer id){
        superManDao.deleteSuperMan(id);
    }

}
