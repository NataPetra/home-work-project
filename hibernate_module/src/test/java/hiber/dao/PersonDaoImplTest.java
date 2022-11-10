package hiber.dao;

import hiber.model.Person;
import lombok.SneakyThrows;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoImplTest extends BaseDaoTest {

    PersonDaoImpl targetObject;

    @Before
    public void setUp() throws Exception {
        targetObject = new PersonDaoImpl(testSessionFactory);
    }

    @After
    public void tearDown() throws Exception {
        targetObject = null;
        Connection conn = testMysqlJdbcDataSource.getConnection();
        conn.createStatement().executeUpdate("delete from Person;");
        conn.close();
    }

    @Test
    @SneakyThrows
    public void create() {
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from Person;");
        rs.next();
        int initialSize = rs.getInt(1);
        assertEquals(0, initialSize);

        Person person = new Person();
        person.setName("Kate");
        person.setAge(60);
        person.setSurname("Kit");


        //When
        targetObject.create(person);

        //Then
        rs = conn.createStatement().executeQuery("select count(*) from Person;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(1, actualSize);
    }

    @Test
    @SneakyThrows
    public void readAll() {
        //Given
        IDataSet personDataSet = new FlatXmlDataSetBuilder()
                .build(getClass().getResourceAsStream("PersonDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, personDataSet);

        //When
        List<Person> personList = targetObject.readAll();

        //Then
        assertEquals(5, personList.size());
        DatabaseOperation.DELETE_ALL.execute(iDatabaseConnection, personDataSet);
    }

    @Test
    @SneakyThrows
    public void update() {
        IDataSet personDataSet = new FlatXmlDataSetBuilder()
                .build(getClass().getResourceAsStream("PersonDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, personDataSet);

        List<Person> persons = targetObject.readAll();
        assertNotNull(persons);
        Person person = persons.get(0);
        person.setName("Lili");

        //When
        targetObject.update(person);

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select name from Person WHERE id=1;");
        rs.next();
        String actualName = rs.getString("name");
        assertEquals("Lili", actualName);
    }

    @Test
    @SneakyThrows
    public void delete() {
        //Given
        IDataSet personDataSet = new FlatXmlDataSetBuilder()
                .build(getClass().getResourceAsStream("PersonDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, personDataSet);

        //When
        List<Person> persons = targetObject.readAll();
        assertNotNull(persons);
        for (Person person: persons) {
            targetObject.delete(person);
        }

        //Then
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from Person;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(0, actualSize);
    }

    @Test
    @SneakyThrows
    public void testDelete() {
        //Given
        Person person = new Person();
        person.setName("Kate");
        person.setAge(60);
        person.setSurname("Kit");

        //When
        targetObject.create(person);
        Connection conn = testMysqlJdbcDataSource.getConnection();
        ResultSet rs = conn.createStatement().executeQuery("select count(*) from Person;");
        rs.next();
        int sizeBeforeDelete = rs.getInt(1) - 1;

        //Then
        targetObject.delete(person);
        rs = conn.createStatement().executeQuery("select count(*) from Person;");
        rs.next();
        int actualSize = rs.getInt(1);
        assertEquals(sizeBeforeDelete, actualSize);
    }
}