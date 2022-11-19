package orm.task_6.model.task8.subclass;

import orm.task_6.model.task8.subclass.dao.SubclassDaoImpl;

import java.math.BigDecimal;

public class MainTest {

    public static void main(String[] args) {
        Person2 student1 = new Student2(null, "male", 20, "Nik", "DNH", 6.5);
        Person2 student2 = new Student2(null, "female", 21, "Nika", "SNH", 8.5);
        Person2 teacher1 = new Teacher2(null, "female", 40, "Kate", "CS", new BigDecimal(6550));
        Person2 teacher2 = new Teacher2(null, "male", 48, "Jon", "JD", new BigDecimal(8670));

        SubclassDaoImpl dao = new SubclassDaoImpl();

        dao.create(student1);
        dao.create(student2);
        dao.create(teacher1);
        dao.create(teacher2);
        System.out.println(dao.readAll());
    }
}
