package repositories;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by yanik on 4/12/15.
 */
@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AnimalRepositoryTest  extends AbstractJUnit4SpringContextTests {
    @Autowired
    private AnimalRepository animalRepo;

    private Keeper keeper;
    private Keeper keeper2;

    @Before
    public void setup() {
        // remove existing data
        animalRepo.deleteAll();

        // create test data
        keeper = new Keeper("Max","Muster",LocalDate.now(),LocalDate.now());
        keeper2 = new Keeper("Peter","Muster",LocalDate.now(),LocalDate.now());
        Compound compound = new Compound(100,10);
        Animal a1 = new Animal(Animal.AnimalSpecies.Katze,"Bob",LocalDate.now(),keeper,compound);
        Animal a2 = new Animal(Animal.AnimalSpecies.Hund,"Hans",LocalDate.now(),keeper,compound);
        Animal a3 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Franz",LocalDate.now(),keeper,compound);
        Animal a4 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Tanz",LocalDate.now(),keeper2,compound);
        animalRepo.save(a1);
        animalRepo.save(a2);
        //animalRepo.save(a3);
        //animalRepo.save(a4);
    }

    @Test
    public void testFindByName() {

        List<Animal> byName = animalRepo.findByName("Bob");

        Assert.assertNotNull(byName);
        Assert.assertEquals(1, byName.size());
        Assert.assertNotNull(byName.get(0));
    }

    @Test
    public void testFindByKeeper() {
        List<Animal> animals = animalRepo.findByKeeper(keeper);

        Assert.assertNotNull(animals);
        Assert.assertEquals(1, animals.size());
        Assert.assertEquals(keeper, animals.get(0).getKeeper());
    }

    @Test
    public void testFindBySpecies(){
        List<Animal> animals = animalRepo.findBySpecies(Animal.AnimalSpecies.Meerschweinchen);
        Assert.assertNotNull(animals);
        //Assert.assertEquals(2, animals.size());

        for(Animal a : animals){
            //Assert.assertEquals(a.getSpecies(),Animal.AnimalSpecies.Meerschweinchen);
        }
    }
}
