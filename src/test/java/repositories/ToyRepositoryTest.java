package repositories;

import at.thurnhaeuser.animalshelter.model.Toy;
import at.thurnhaeuser.animalshelter.repositories.ToyRepository;
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
public class ToyRepositoryTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ToyRepository toyRepository;

    @Test
    public void createToy(){
        toyRepository.deleteAll();
        Toy t = new Toy(Toy.Material.wood,Toy.Color.red,"KA",145.9);
        toyRepository.save(t);
    }

    @Test
    public void ToyTest(){
        toyRepository.deleteAll();

        Toy t = new Toy(Toy.Material.wood,Toy.Color.red,"KA",145.9);
        toyRepository.save(t);

        Assert.assertEquals(1,toyRepository.count());
        Assert.assertEquals(true, toyRepository.exists(t.getId()));
        Assert.assertEquals(t,toyRepository.findOne(t.getId()));

    }

    @Test
    public void FindToyByID(){
        toyRepository.deleteAll();
        ArrayList<Toy> at = new ArrayList<>();
        Toy t = new Toy(Toy.Material.wood,Toy.Color.red,"KA",145.9);
        Toy t2 = new Toy(Toy.Material.wood,Toy.Color.green,"BLABLA",145.9);
        Toy t3 = new Toy(Toy.Material.rubber,Toy.Color.red,"KA2",145.9);
        Toy t4 = new Toy(Toy.Material.plastic,Toy.Color.brown,"IQ",145.9);
        at.add(t);
        at.add(t2);
        at.add(t3);
        at.add(t4);
        toyRepository.save(t);
        toyRepository.save(t2);
        toyRepository.save(t3);
        toyRepository.save(t4);

        Assert.assertNotNull(t.getId());
        Assert.assertEquals(4,toyRepository.count());
        Assert.assertNotEquals(t2,toyRepository.exists(t.getId()));
        Assert.assertEquals(at, toyRepository.findAll());
    }

}
