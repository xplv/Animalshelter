package persistence;

import org.junit.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by philip on 11.04.2015.
 */
public class AbstractDaoTest {
    protected static EntityManager entityManager;

    @BeforeClass
    public static void beforeClass() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpengergassePU");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @AfterClass
    public static void afterClass() {
        if (entityManager != null) {
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
