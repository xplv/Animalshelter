package repositories;

import at.thurnhaeuser.animalshelter.model.Toy;
import at.thurnhaeuser.animalshelter.repositories.ToyRepository;
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
public class ToyRepositoryTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ToyRepository toyRepository;

    @Test
    public void createToy(){
        Toy t = new Toy(Toy.Material.wood,Toy.Color.red,"KA",145.9);
        toyRepository.save(t);
    }

    @Test
    public void ToyTest(){
        Toy t = new Toy(Toy.Material.wood,Toy.Color.red,"KA",145.9);
        toyRepository.save(t);
        long x = toyRepository.count();
        Assert.assertEquals(x,toyRepository.count());
        Assert.assertEquals(true, toyRepository.exists(t.getId()));
        Assert.assertEquals(t,toyRepository.findOne(t.getId()));

    }

    @Test
    public void FindToyByIDAndFindAll(){
        ArrayList<Toy> at = new ArrayList<>();
        Toy t = new Toy(Toy.Material.wood,Toy.Color.red,"KA",145.9);
        Toy t2 = new Toy(Toy.Material.wood,Toy.Color.green,"BLABLA",145.9);
        Toy t3 = new Toy(Toy.Material.rubber,Toy.Color.red,"KA2",145.9);
        Toy t4 = new Toy(Toy.Material.plastic,Toy.Color.brown,"IQ",145.9);
        at.add(t);
        at.add(t2);
        at.add(t3);
        at.add(t4);
        toyRepository.save(at);

        Assert.assertNotNull(t.getId());
        Assert.assertNotEquals(t2,toyRepository.exists(t.getId()));
        ArrayList<Toy>at2 = Lists.newArrayList(toyRepository.findAll());
        for(Toy tf : at){
            Assert.assertTrue(at2.contains(tf));
        }
    }

}
