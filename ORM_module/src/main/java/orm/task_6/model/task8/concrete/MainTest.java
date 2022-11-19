package orm.task_6.model.task8.concrete;

import orm.task_6.model.task8.concrete.dao.ConcreteClassDaoImpl;

import java.math.BigDecimal;

public class MainTest {

    public static void main(String[] args) {
        Person3 student1 = new Student3(null, "male", 20, "Nik", "DNH", 6.5);
        Person3 student2 = new Student3(null, "female", 21, "Nika", "SNH", 8.5);
        Person3 teacher1 = new Teacher3(null, "female", 40, "Kate", "CS", new BigDecimal(6550));
        Person3 teacher2 = new Teacher3(null, "male", 48, "Jon", "JD", new BigDecimal(8670));
        Person3 person = new Person3(null, "male", 15, "Jona");

        ConcreteClassDaoImpl dao = new ConcreteClassDaoImpl();

        dao.create(student1);
        dao.create(student2);
        dao.create(teacher1);
        dao.create(teacher2);
        dao.create(person);
        System.out.println(dao.readAll());
    }
}
