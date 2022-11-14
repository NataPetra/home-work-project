package orm.task_6.loader;

import orm.task_6.dao.AnimalDao;
import orm.task_6.dao.AnimalDaoImpl;
import orm.task_6.dao.ManDao;
import orm.task_6.dao.ManDaoImpl;
import orm.task_6.model.Animal;
import orm.task_6.model.Man;
import orm.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        Man man = new Man(null, 20, "Mi", "Smith");
        Man man2 = new Man(null, 25, "Ki", "Smith");
        Animal animal = new Animal(null, "cat", 1, "May");
        Animal animal2 = new Animal(null, "dog", 4, "Gret");

        ManDao manDao = new ManDaoImpl();
        AnimalDao animalDao = new AnimalDaoImpl();
        manDao.create(man);
        manDao.create(man2);

        animalDao.create(animal);
        animalDao.create(animal2);

        System.out.println("Id from Persistent Man: " + manDao.readAllId());

        List<Man> readAllMans = manDao.readAll();
        List<Integer> idMans = new ArrayList<>();
        for (Man mans : readAllMans) {
            idMans.add(mans.getId());
        }
        System.out.println("Id from Detached Man: " + idMans);

        System.out.println("Id from Persistent Animal: " + animalDao.readAllId());

        List<Animal> readAllAnimals = animalDao.readAll();
        List<Integer> idAnimals = new ArrayList<>();
        for (Animal animals : readAllAnimals) {
            idAnimals.add(animals.getId());
        }
        System.out.println("Id from Detached Animal: " + idAnimals);
    }
}
