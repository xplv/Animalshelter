package repositories;

import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.repositories.CompoundRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.ArrayList;

/**
 * Created by philip on 12.04.2015.
 */
@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class CompoundRepositoryTest extends AbstractJUnit4SpringContextTests{
    @Autowired
    private CompoundRepository compoundRepository;

    @Test
    public void createCompound(){
        compoundRepository.deleteAll();

        Compound c = new Compound(149.0,34);
        compoundRepository.save(c);
    }

    @Test
    public void CompoundTest(){
        compoundRepository.deleteAll();

        Compound c = new Compound(149.0,34);
        compoundRepository.save(c);

        Assert.assertEquals(1,compoundRepository.count());
        Assert.assertEquals(true, compoundRepository.exists(c.getId()));
        Assert.assertEquals(c,compoundRepository.findOne(c.getId()));
    }

    @Test
    public void FindCompoundByIdAndFindAll(){
        compoundRepository.deleteAll();
        ArrayList<Compound> ac = new ArrayList<>();
        Compound c = new Compound(149.0,31);
        Compound c2 = new Compound(191.0,64);
        Compound c3 = new Compound(12.0,4);
        Compound c4 = new Compound(109.0,374);
        ac.add(c);
        ac.add(c2);
        ac.add(c3);
        ac.add(c4);
        compoundRepository.save(c);
        compoundRepository.save(c2);
        compoundRepository.save(c3);
        compoundRepository.save(c4);

        Assert.assertNotNull(c.getId());
        Assert.assertEquals(4,compoundRepository.count());
        Assert.assertNotEquals(c2, compoundRepository.findOne(c4.getId()));
        Assert.assertEquals(ac,compoundRepository.findAll());
    }
}
