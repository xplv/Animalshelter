package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by philip on 10.04.2015.
 */
public class DaoAnimalShelterFactory {
    private Map<Class, Dao> daoMap;
    private EntityManager entityManager;

    public DaoAnimalShelterFactory(EntityManager entityManager){
        this.entityManager = entityManager;

        daoMap = new HashMap<Class, Dao>();
        daoMap.put(Animal.class, new DaoAnimal(entityManager));
        daoMap.put(Compound.class, new DaoCompound(entityManager));
        daoMap.put(Keeper.class, new DaoKeeper(entityManager));
    }

    public Dao<Animal> getDaoAnimal(){
        return daoMap.get(Animal.class);
    }

    public Dao<Compound> getDaoCompound(){
        return daoMap.get(Compound.class);
    }

    public Dao<Keeper> getDaoKeeper(){
        return daoMap.get(Keeper.class);
    }
}
