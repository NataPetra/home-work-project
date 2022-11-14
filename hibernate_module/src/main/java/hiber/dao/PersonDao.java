package hiber.dao;

import hiber.model.Person;

import java.util.List;

public interface PersonDao {

    void create(Person person);

    Person getPerson(Integer id);

    List<Person> readAll();

    void update(Person person);

    void delete(Person person);

    void delete(long id);
}
