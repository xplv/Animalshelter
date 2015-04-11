package model;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import junit.framework.Assert;
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
    @Test
    public void createMoreAnimals(){
        Keeper k1 = new Keeper("hans","muster", LocalDate.of(1996, 12, 30),LocalDate.of(1996,12,30));
        Compound c1 = new Compound(100,10);
        Animal a1 = new Animal(Animal.AnimalSpecies.Hund,"Bello",LocalDate.now());
        Animal a2 = new Animal(Animal.AnimalSpecies.Katze,"Tiger",LocalDate.now());
        Animal a3 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Fulffy",LocalDate.now());

        k1.addAnimal(a1);
        k1.addAnimal(a2);
        k1.addAnimal(a3);

        assertEquals(k1.getAnimals().size(),3);
    }
}
