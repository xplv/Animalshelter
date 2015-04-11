package persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.persistence.DaoCompound;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.util.resources.cldr.ar.CalendarData_ar_OM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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
    public void persistCompound(){
        Compound compound = new Compound(120.5,21);
        Assert.assertNull(compound.getId());
        rootDaoCompound.persist(compound);
        Assert.assertNotNull(compound.getId());
    }

    @Test
    public void persistFindCompound(){
        Compound c1 = new Compound(150.3,50);
        rootDaoCompound.persist(c1);
        Assert.assertEquals(c1,rootDaoCompound.findById(c1.getId()));
    }

    @Test
    public void persistFindAllCompounds() {
        ArrayList<Compound>compound = new ArrayList<>();
        Compound compound2 = new Compound(120.6, 33);
        Compound compound3 = new Compound(150.3, 50);
        compound.add(compound2);
        compound.add(compound3);
        rootDaoCompound.persist(compound2);
        rootDaoCompound.persist(compound3);
        for(Compound c : compound){
            Assert.assertTrue(rootDaoCompound.findAll().contains(c));
        }
    }

}



