package orm.task_6.model.task8.concrete.dao;

import orm.task_6.model.task8.concrete.Person3;

import java.util.List;

public interface ConcreteClassDao<T>{

    void create(Person3 person);

    List<T> readAll();

}
