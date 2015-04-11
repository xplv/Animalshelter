package persistence;

import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.persistence.DaoCompound;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by philip on 11.04.2015.
 */
public class DaoCompoundTest extends AbstractDaoTest {
    private DaoCompound rootDaoCompound;

    @Before
    public void before(){
        rootDaoCompound = new DaoCompound(AbstractDaoTest.entityManager);
    }

    @Test
    public void persistNewObject(){
        Compound compound = buildSampleCompound();
        Assert.assertNull(compound.getId());
        rootDaoCompound.persist(compound);
        Assert.assertNotNull(compound.getId());
    }


    private Compound buildSampleCompound(){
        Compound compound = new Compound(46.7,150);
        compound.setSizeInSqm(150.5);
        compound.setMaxAnimals(23);
        return compound;
    }
}
