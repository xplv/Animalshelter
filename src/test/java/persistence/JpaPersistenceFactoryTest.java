package persistence;

import at.thurnhaeuser.animalshelter.persistence.JpaPersistenceFactory;
import at.thurnhaeuser.animalshelter.persistence.JpaPersistenceFactoryImpl;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by philip on 11.04.2015.
 */
public class JpaPersistenceFactoryTest {
    private static EntityManager entityManager;

    @BeforeClass
    public static void constructEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SpengergassePU");
        entityManager = factory.createEntityManager();
    }

    @AfterClass
    public static void desctructEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructWithoutEntityManager() {
        new JpaPersistenceFactoryImpl(null);
    }

    @Test
    public void constructWithValidEntityManager() {
        JpaPersistenceFactory jpaPersistenceFactory = new JpaPersistenceFactoryImpl(entityManager);

        Assert.assertNotNull(jpaPersistenceFactory.daoAnimal());
        Assert.assertNotNull(jpaPersistenceFactory.daoCompound());
        Assert.assertNotNull(jpaPersistenceFactory.daoKeeper());
    }
}
