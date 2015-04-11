package model;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

/**
 * Created by yanik on 4/10/15.
 */
public class AnimalshelterTest {
    @Test
    public void createAnimal(){
        Keeper k1 = new Keeper("hans","muster", LocalDate.of(1996, 12, 30),LocalDate.of(1996,12,30));
        Compound c1 = new Compound(100,10);
        Animal a1 = new Animal(Animal.AnimalSpecies.Hund,"Bello",LocalDate.now());
        k1.addAnimal(a1);
        c1.addAnimal(a1);
        assertTrue(k1.getAnimals().contains(a1));
        assertTrue(c1.getAnimals().contains(a1));
    }
}
