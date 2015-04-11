package persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.persistence.DaoAnimal;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by yanik on 4/11/15.
 */
public class DaoAnimalTest {
    private DaoAnimal daoAnimal;

    @Before
    public void before() {
        daoAnimal = new DaoAnimal(AbstractDaoTest.entityManager);
    }

    @Test
    public void persistAnimal(){
        Keeper k1 = new Keeper("Max","Muster", LocalDate.of(1996,1,23),LocalDate.now());
        Compound c1 = new Compound(100,10);
        Animal a1 = new Animal(Animal.AnimalSpecies.Katze,"Mauzi",k1,null,c1,LocalDate.now());
        daoAnimal.persist(a1);
    }
}
