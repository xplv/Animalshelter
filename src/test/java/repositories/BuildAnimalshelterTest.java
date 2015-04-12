package repositories;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.model.Toy;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import at.thurnhaeuser.animalshelter.repositories.CompoundRepository;
import at.thurnhaeuser.animalshelter.repositories.KeeperRepository;
import at.thurnhaeuser.animalshelter.repositories.ToyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanik on 4/12/15.
 */
@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class BuildAnimalshelterTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private AnimalRepository animalRepo;

    @Autowired
    private KeeperRepository keeperRepo;

    @Autowired
    private CompoundRepository compoundRepo;

    private Animal a1;
    private Animal a2;
    private Animal a3;
    private Animal a4;
    private Animal a5;
    private Animal a6;
    private Animal a7;
    private Animal a8;

    @Before
    public void setup() {
        animalRepo.deleteAll();

        ArrayList<Animal> animals = new ArrayList<>();

        // create test data
        Keeper k1 = new Keeper("Max","Muster", LocalDate.now(),LocalDate.now());
        Keeper k2 = new Keeper("Peter","Pass",LocalDate.now(),LocalDate.now());
        Compound c1= new Compound(100,10);
        Compound c2= new Compound(200,20);
        a1 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Bob",LocalDate.now(),k1,c1);
        a2 = new Animal(Animal.AnimalSpecies.Katze,"Frank",LocalDate.now(),k1,c2);
        a3 = new Animal(Animal.AnimalSpecies.Hund,"Paula",LocalDate.now(),k2,c1);
        a4 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Anna",LocalDate.now(),k2,c2);
        a5 = new Animal(Animal.AnimalSpecies.Katze,"Jenny",LocalDate.now(),k1,c1);
        a6 = new Animal(Animal.AnimalSpecies.Hund,"Robby",LocalDate.now(),k1,c2);
        a7 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Pikachu",LocalDate.now(),k2,c1);
        a8 = new Animal(Animal.AnimalSpecies.Katze,"Bob Teil 2",LocalDate.now(),k2,c2);

        animals.add(a1);
        animals.add(a2);
        animals.add(a3);
        animals.add(a4);
        animals.add(a5);
        animals.add(a6);
        animals.add(a7);
        animals.add(a8);

        animalRepo.save(animals);
    }

    @Test
    public void testFindOne(){
        Assert.assertEquals(animalRepo.findOne(a1.getId()), a1);
        Assert.assertEquals(animalRepo.findOne(a2.getId()),a2);
        Assert.assertNotEquals(animalRepo.findOne(a1.getId()),a2);
    }
}
