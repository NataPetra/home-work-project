package hiber.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("hiber");
    }

    public static EntityManager getInstance() {
        return emFactory.createEntityManager();
    }

    public static void close() {
        emFactory.close();
    }
}
