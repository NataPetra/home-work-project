package orm.task_6.model.task8.hierarchy.dao;

import orm.task_6.model.task8.hierarchy.*;

import java.util.List;

public interface SingleTableDao <T>{

    void create(Person person);

    List<T> readAll();

}
