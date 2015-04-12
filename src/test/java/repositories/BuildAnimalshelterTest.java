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

/**
 * Created by yanik on 4/12/15.
 */
@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class BuildAnimalshelterTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private AnimalRepository animalRepo;

    @Autowired
    private CompoundRepository compoundRepo;

    @Autowired
    private KeeperRepository keeperRepo;

    @Autowired
    private ToyRepository toyRepo;

    private Keeper k1;
    private Keeper k2;
    private Compound c1;
    private Compound c2;
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
        compoundRepo.deleteAll();
        keeperRepo.deleteAll();
        toyRepo.deleteAll();

        // create test data
        k1 = new Keeper("Max","Muster", LocalDate.now(),LocalDate.now());
        k2 = new Keeper("Peter","Pass",LocalDate.now(),LocalDate.now());
        c1= new Compound(100,10);
        c2= new Compound(200,20);
        a1 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Bob",LocalDate.now(),k1,c1);
        a2 = new Animal(Animal.AnimalSpecies.Katze,"Frank",LocalDate.now(),k1,c2);
        a3 = new Animal(Animal.AnimalSpecies.Hund,"Paula",LocalDate.now(),k2,c1);
        a4 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Anna",LocalDate.now(),k2,c2);
        a5 = new Animal(Animal.AnimalSpecies.Katze,"Jenny",LocalDate.now(),k1,c1);
        a6 = new Animal(Animal.AnimalSpecies.Hund,"Robby",LocalDate.now(),k1,c2);
        a7 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Pikachu",LocalDate.now(),k2,c1);
        a8 = new Animal(Animal.AnimalSpecies.Katze,"Bob Teil 2",LocalDate.now(),k2,c2);
        compoundRepo.save(c1);
        compoundRepo.save(c2);

        keeperRepo.save(k1);
        keeperRepo.save(k2);

        animalRepo.save(a1);
        animalRepo.save(a2);
        animalRepo.save(a3);
        animalRepo.save(a4);
        animalRepo.save(a5);
        animalRepo.save(a6);
        animalRepo.save(a7);
        animalRepo.save(a8);
    }

    @Test
    public void testFindOne(){
        Assert.assertTrue(true);
    }
}
