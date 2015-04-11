package persistence;

import at.thurnhaeuser.animalshelter.model.Toy;
import at.thurnhaeuser.animalshelter.persistence.DaoToy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by philip on 11.04.2015.
 */
public class DaoToyTest extends AbstractDaoTest {
    private DaoToy daoToy;

    @Before
    public void before(){daoToy = new DaoToy(AbstractDaoTest.entityManager);}

    @Test
    public void persistToy(){
        Toy t = new Toy(Toy.Material.wood,Toy.Color.brown,"Woodn Ball",168.5);
        daoToy.persist(t);
    }

    @Test
    public  void FindByIDToy(){
        Toy t = new Toy(Toy.Material.wood,Toy.Color.brown,"Woodn Ball",168.5);
        daoToy.persist(t);
        Assert.assertEquals(t,daoToy.findById(t.getId()));
    }

    @Test
    public void FindAllToys(){
        ArrayList<Toy>toy = new ArrayList<>();
        Toy t = new Toy(Toy.Material.wood,Toy.Color.brown,"Woodn Ball",168.5);
        Toy t2 = new Toy(Toy.Material.plastic,Toy.Color.red,"Plastic Ball",19.8);
        Toy t3 = new Toy(Toy.Material.rubber,Toy.Color.green,"Rubber Ball",10.5);

        toy.add(t);
        toy.add(t2);
        toy.add(t3);
        daoToy.persist(t);
        daoToy.persist(t2);
        daoToy.persist(t3);

        for(Toy t4 : toy){
            Assert.assertTrue(daoToy.findAll().contains(t4));
        }

    }

}
