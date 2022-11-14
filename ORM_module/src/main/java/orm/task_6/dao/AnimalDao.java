package orm.task_6.dao;

import orm.task_6.model.Animal;

import java.util.List;

public interface AnimalDao {

    void create(Animal animal);

    List<Animal> readAll();

    List readAllId();
}
