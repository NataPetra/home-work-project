package my.dao;

import my.entity.SuperMan;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperManDao {

    void addSuperMan(SuperMan superMan);
    SuperMan getSuperMan(Integer id);
    void deleteSuperMan(Integer id);

}
