package repositories;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.model.Toy;
import at.thurnhaeuser.animalshelter.repositories.AnimalRepository;
import at.thurnhaeuser.animalshelter.repositories.CompoundRepository;
import at.thurnhaeuser.animalshelter.repositories.KeeperRepository;
import at.thurnhaeuser.animalshelter.repositories.ToyRepository;
import com.google.common.collect.Lists;
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
    @Autowired
    private ToyRepository toyRepo;

    private ArrayList<Animal> animals;
    private ArrayList<Compound> compounds;
    private ArrayList<Keeper> keepers;
    private ArrayList<Toy> toys;

    @Before
    public void setup() {
        animalRepo.deleteAll();
        keeperRepo.deleteAll();
        compoundRepo.deleteAll();
        toyRepo.deleteAll();

        animals = new ArrayList<>();
        compounds = new ArrayList<>();
        keepers = new ArrayList<>();
        toys = new ArrayList<>();

        Keeper k1 = new Keeper("Max","Muster", LocalDate.now(),LocalDate.now());
        Keeper k2 = new Keeper("Peter","Pass",LocalDate.now(),LocalDate.now());
        keepers.add(k1);
        keepers.add(k2);
        Compound c1= new Compound(100,10);
        Compound c2= new Compound(200,20);
        compounds.add(c1);
        compounds.add(c2);
        Animal a1 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Bob",LocalDate.now(),k1,c1);
        Animal a2 = new Animal(Animal.AnimalSpecies.Katze,"Frank",LocalDate.now(),k1,c2);
        Animal a3 = new Animal(Animal.AnimalSpecies.Hund,"Paula",LocalDate.now(),k2,c1);
        Animal a4 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Anna",LocalDate.now(),k2,c2);
        Animal a5 = new Animal(Animal.AnimalSpecies.Katze,"Jenny",LocalDate.now(),k1,c1);
        Animal a6 = new Animal(Animal.AnimalSpecies.Hund,"Robby",LocalDate.now(),k1,c2);
        Animal a7 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Pikachu",LocalDate.now(),k2,c1);
        Animal a8 = new Animal(Animal.AnimalSpecies.Katze,"Bob Teil 2",LocalDate.now(),k2,c2);

        Toy t1 = new Toy(Toy.Material.wood, Toy.Color.green,"Würfel",10);
        Toy t2 = new Toy(Toy.Material.rubber, Toy.Color.red,"Ball",10);
        a1.addToy(t1);
        a1.addToy(t2);
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
        Assert.assertEquals(animalRepo.findOne(animals.get(0).getId()), animals.get(0));
        Assert.assertEquals(animalRepo.findOne(animals.get(1).getId()),animals.get(1));
        Assert.assertNotEquals(animalRepo.findOne(animals.get(0).getId()), animals.get(1));
    }

    @Test
    public void testFindAll(){
        ArrayList<Animal> animalsFromReps = Lists.newArrayList(animalRepo.findAll());
        for(Animal a : animals){
            Assert.assertTrue(animalsFromReps.contains(a));
        }
        ArrayList<Compound> compoundsFromReps = Lists.newArrayList(compoundRepo.findAll());
        for(Compound c : compounds){
            Assert.assertTrue(compoundsFromReps.contains(c));
        }
        ArrayList<Keeper> keepersFromReps = Lists.newArrayList(keeperRepo.findAll());
        for(Keeper k : keepers){
            Assert.assertTrue(keepersFromReps.contains(k));
        }
        ArrayList<Toy> toysFromReps = Lists.newArrayList(toyRepo.findAll());
        for(Toy t : toys){
            Assert.assertTrue(toysFromReps.contains(t));
        }
    }

    @Test
    public void testFindBySpecies(){
        ArrayList<Animal> animalsFromReps = Lists.newArrayList(animalRepo.findBySpecies(Animal.AnimalSpecies.Meerschweinchen));
        for(Animal a : animals){
            if(a.getSpecies() == Animal.AnimalSpecies.Meerschweinchen){
                Assert.assertTrue(animalsFromReps.contains(a));
            }
        }
    }

    @Test
    public void testFindAllMeerschweinchenFromKeeper(){
        ArrayList<Animal> animalsFromReps = Lists.newArrayList(animalRepo.findAllMeerschweinchenFromKeeper(keepers.get(1)));
        for(Animal a : animals){
            if(a.getSpecies() == Animal.AnimalSpecies.Meerschweinchen && a.getKeeper() == keepers.get(1)){
                Assert.assertTrue(animalsFromReps.contains(a));
            }
        }
    }
}
