package persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.persistence.DaoAnimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by yanik on 4/11/15.
 */
public class DaoAnimalTest extends AbstractDaoTest  {
    private DaoAnimal daoAnimal;

    @Before
    public void before() {
        daoAnimal = new DaoAnimal(AbstractDaoTest.entityManager);
    }

    @Test
    public void persistAnimal(){
        Animal a1 = new Animal(Animal.AnimalSpecies.Katze,"Mauzi",LocalDate.now());
        daoAnimal.persist(a1);
    }

    @Test
    public void persistAnimalAndFindIt(){
        Animal a1 = new Animal(Animal.AnimalSpecies.Katze,"Miaumiau",LocalDate.now());
        daoAnimal.persist(a1);
        Assert.assertEquals(a1,daoAnimal.findById(a1.getId()));
    }
    @Test
    public void persistAnimalAndFindAll(){
        ArrayList<Animal> animals = new ArrayList<>();
        Animal a1 = new Animal(Animal.AnimalSpecies.Katze,"Miaumiau",LocalDate.now());
        Animal a2 = new Animal(Animal.AnimalSpecies.Hund,"Wuffwuff",LocalDate.now());
        Animal a3 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"quiekquiek",LocalDate.now());

        animals.add(a1);
        animals.add(a2);
        animals.add(a3);

        for(Animal a : animals){
            daoAnimal.persist(a);
        }

        Assert.assertArrayEquals(animals.toArray(),daoAnimal.findAll().toArray());
    }
}
