package orm.task_6.model.task8.hierarchy;

import orm.task_6.model.task8.hierarchy.dao.SingleTableDaoImpl;

import java.math.BigDecimal;

public class MainTest {

    public static void main(String[] args) {
        Person student1 = new Student(null, "male", 20, "Nik", "DNH", 6.5);
        Person student2 = new Student(null, "female", 21, "Nika", "SNH", 8.5);
        Person teacher1 = new Teacher(null, "female", 40, "Kate", "CS", new BigDecimal(6550));
        Person teacher2 = new Teacher(null, "male", 48, "Jon", "JD", new BigDecimal(8670));

        SingleTableDaoImpl dao = new SingleTableDaoImpl();

        dao.create(student1);
        dao.create(student2);
        dao.create(teacher1);
        dao.create(teacher2);
        System.out.println(dao.readAll());
    }
}
