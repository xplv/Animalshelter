package persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.persistence.DaoAnimal;
import at.thurnhaeuser.animalshelter.persistence.DaoKeeper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by yanik on 4/11/15.
 */
public class DaoKeeperTest extends AbstractDaoTest {
    private DaoKeeper daoKeeper;
    @Before
    public void before() {
        daoKeeper = new DaoKeeper(AbstractDaoTest.entityManager);
    }

    @Test
    public void persistKeeper(){
        Keeper k1 = new Keeper("Max","Muster", LocalDate.of(1234,12,3),LocalDate.now());
        daoKeeper.persist(k1);
    }
    @Test
    public void persistKeeperWithAnimal() {
        Keeper k1 = new Keeper("Max", "Muster", LocalDate.of(1234, 12, 3), LocalDate.now());
        Animal a1 = new Animal(Animal.AnimalSpecies.Meerschweinchen, "Blacky", LocalDate.now());
        k1.addAnimal(a1);
        daoKeeper.persist(k1);
        Assert.assertEquals(k1,daoKeeper.findById(k1.getId()));
        Assert.assertTrue(daoKeeper.findById(k1.getId()).getAnimals().contains(a1));
    }
    @Test
    public void persistKeeperWithMoreAnimals(){
        Keeper k1 = new Keeper("Max", "Muster", LocalDate.of(1234, 12, 3), LocalDate.now());
        Animal a1 = new Animal(Animal.AnimalSpecies.Meerschweinchen, "Blacky", LocalDate.now());
        Animal a2 = new Animal(Animal.AnimalSpecies.Hund, "Bello", LocalDate.now());
        Animal a3 = new Animal(Animal.AnimalSpecies.Katze, "Socke", LocalDate.now());
        k1.addAnimal(a1);
        k1.addAnimal(a2);
        k1.addAnimal(a3);

        daoKeeper.persist(k1);
        Keeper k1dao = daoKeeper.findById(k1.getId());

        Assert.assertEquals(k1.getAnimals().size(), k1dao.getAnimals().size());
        for(Animal a : k1.getAnimals()){
            Assert.assertTrue(k1dao.getAnimals().contains(a));
        }
    }
     @Test
    public void peristMultibleKeepers(){
         ArrayList<Keeper> keepers = new ArrayList<>();
         Keeper k1 = new Keeper("Max", "Muster", LocalDate.of(1234, 12, 3), LocalDate.now());
         Keeper k2 = new Keeper("Hans", "Muster", LocalDate.of(1234, 12, 3), LocalDate.now());
         Keeper k3 = new Keeper("Grätchen", "Muster", LocalDate.of(1234, 12, 3), LocalDate.now());

         keepers.add(k1);
         keepers.add(k2);
         keepers.add(k3);
         daoKeeper.persist(k1);
         daoKeeper.persist(k2);
         daoKeeper.persist(k3);

         for(Keeper k : keepers){
             Assert.assertTrue(daoKeeper.findAll().contains(k));
         }
     }
}
