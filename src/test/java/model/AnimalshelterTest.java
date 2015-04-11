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
        Animal a1 = new Animal(Animal.AnimalSpecies.Hund,"Bello",LocalDate.now(),k1,c1);
        assertEquals(a1.getKeeper(), k1);
        assertEquals(a1.getCompound(),c1);
    }

    @Test
    public void createMoreAnimals(){
        Keeper k1 = new Keeper("hans","muster", LocalDate.of(1996, 12, 30),LocalDate.of(1996,12,30));
        Compound c1 = new Compound(100,10);
        Animal a1 = new Animal(Animal.AnimalSpecies.Hund,"Bello",LocalDate.now(),k1,c1);
        Animal a2 = new Animal(Animal.AnimalSpecies.Katze,"Tiger",LocalDate.now(),k1,c1);
        Animal a3 = new Animal(Animal.AnimalSpecies.Meerschweinchen,"Fulffy",LocalDate.now(),k1,c1);

        assertEquals(a1.getCompound(),a2.getCompound());
        assertEquals(a1.getCompound(),a3.getCompound());
        assertEquals(a3.getCompound(),a2.getCompound());

        assertEquals(a1.getKeeper(),a2.getKeeper());
        assertEquals(a1.getKeeper(),a3.getKeeper());
        assertEquals(a3.getKeeper(),a2.getKeeper());
    }
}
