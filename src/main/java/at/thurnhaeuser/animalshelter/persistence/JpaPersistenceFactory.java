package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
/**
 * Created by yanik on 4/11/15.
 */
public interface JpaPersistenceFactory {
    Dao<Animal> daoAnimal();

    Dao<Keeper> daoKeeper();

    Dao<Compound> daoCompound();
}
