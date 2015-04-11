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
        Animal a2 = daoAnimal.findById(a1.getId());
    }
}
