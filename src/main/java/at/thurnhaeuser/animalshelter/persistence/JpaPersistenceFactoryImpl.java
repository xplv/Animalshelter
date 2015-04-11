package at.thurnhaeuser.animalshelter.persistence;

import at.thurnhaeuser.animalshelter.model.Animal;
import at.thurnhaeuser.animalshelter.model.Compound;
import at.thurnhaeuser.animalshelter.model.Keeper;
import at.thurnhaeuser.animalshelter.model.Toy;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanik on 4/11/15.
 */
public class JpaPersistenceFactoryImpl implements JpaPersistenceFactory {

    private final Map<Class<?>, Dao<?>> daoMap = new HashMap<>();

    public JpaPersistenceFactoryImpl(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager must be given.");
        }

        daoMap.put(Animal.class, new DaoAnimal(entityManager));
        daoMap.put(Keeper.class, new DaoKeeper(entityManager));
        daoMap.put(Compound.class, new DaoCompound(entityManager));
    }

    public Dao<Animal> daoAnimal() {
        return (Dao<Animal>) daoMap.get(Animal.class);
    }

    public Dao<Keeper> daoKeeper() {
        return (Dao<Keeper>) daoMap.get(Keeper.class);
    }

    public Dao<Compound> daoCompound() {
        return (Dao<Compound>) daoMap.get(Compound.class);
    }

    public Dao<Toy> daoToy() {
        return (Dao<Toy>) daoMap.get(Toy.class);
    }
}
