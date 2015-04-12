package repositories;

import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.repositories.KeeperRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by philip on 12.04.2015.
 */
@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class KeeperRepositoryTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private KeeperRepository keeperRepository;

    @Test
    public void createKeeper(){
        keeperRepository.deleteAll();
        Keeper k = new Keeper("Klaus","Santa", LocalDate.now(),LocalDate.of(1929, 9, 3));
        keeperRepository.save(k);
    }

    @Test
    public void KeeperTest(){
        keeperRepository.deleteAll();
        Keeper k = new Keeper("Klaus","Santa", LocalDate.now(),LocalDate.of(1929, 9, 3));
        keeperRepository.save(k);

        Assert.assertEquals(1,keeperRepository.count());
        Assert.assertEquals(true, keeperRepository.exists(k.getId()));
        Assert.assertEquals(k,keeperRepository.findOne(k.getId()));
    }

    @Test
    public void FindKeeperByIdAndFindAll(){
        ArrayList<Keeper>ak = new ArrayList<>();
        Keeper k = new Keeper("Klaus","Santa", LocalDate.now(),LocalDate.of(1929, 9, 3));
        Keeper k2 = new Keeper("Mrs","Klaus", LocalDate.now(),LocalDate.of(1921, 9, 3));
        Keeper k3 = new Keeper("Jonny","Bagci", LocalDate.now(),LocalDate.of(1956, 10, 3));
        Keeper k4 = new Keeper("Felix","Pewdiepie", LocalDate.now(),LocalDate.of(1, 9, 30));
        ak.add(k);
        ak.add(k2);
        ak.add(k3);
        ak.add(k4);
        keeperRepository.save(k);
        keeperRepository.save(k2);
        keeperRepository.save(k3);
        keeperRepository.save(k4);

        Assert.assertNotNull(k.getId());
        Assert.assertEquals(4,keeperRepository.count());
        Assert.assertNotEquals(k4,keeperRepository.findOne(k2.getId()));
        Assert.assertEquals(ak,keeperRepository.findAll());

    }
}
