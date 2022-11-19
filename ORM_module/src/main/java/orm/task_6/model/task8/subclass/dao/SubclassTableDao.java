package orm.task_6.model.task8.subclass.dao;

import orm.task_6.model.task8.subclass.Person2;

import java.util.List;

public interface SubclassTableDao<T>{

    void create(Person2 person);

    List<T> readAll();

}
