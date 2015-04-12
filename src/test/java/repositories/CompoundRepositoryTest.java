package repositories;

import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.repositories.CompoundRepository;
import com.google.common.collect.Lists;
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
        Compound c = new Compound(149.0,34);
        compoundRepository.save(c);
    }

    @Test
    public void CompoundTest(){
        Compound c = new Compound(149.0,34);
        compoundRepository.save(c);
        long x = compoundRepository.count();
        Assert.assertEquals(x,compoundRepository.count());
        Assert.assertEquals(true, compoundRepository.exists(c.getId()));
        Assert.assertEquals(c, compoundRepository.findOne(c.getId()));
    }

    @Test
    public void FindCompoundByIdAndFindAll(){
        ArrayList<Compound> ac = new ArrayList<>();
        Compound c = new Compound(149.0,31);
        Compound c2 = new Compound(191.0,64);
        Compound c3 = new Compound(12.0,4);
        Compound c4 = new Compound(109.0,374);
        ac.add(c);
        ac.add(c2);
        ac.add(c3);
        ac.add(c4);
        compoundRepository.save(ac);

        Assert.assertNotNull(c.getId());
        Assert.assertNotEquals(c2, compoundRepository.findOne(c4.getId()));
        ArrayList<Compound> ac2 = Lists.newArrayList(compoundRepository.findAll());
        for(Compound cf : ac) {
            Assert.assertTrue(ac2.contains(cf));
        }
    }
}
