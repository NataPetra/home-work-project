package orm.task_6.dao;

import orm.task_6.model.Man;

import java.util.List;

public interface ManDao {

    void create(Man man);

    List<Man> readAll();

    List<Integer> readAllId();

}
